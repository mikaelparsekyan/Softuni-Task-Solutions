package alararestaurant.service;

import alararestaurant.constants.FileImportPaths;
import alararestaurant.domain.dtos.OrdersImportDto;
import alararestaurant.domain.entities.Item;
import alararestaurant.domain.entities.Order;
import alararestaurant.domain.entities.OrderItem;
import alararestaurant.domain.entities.enums.OrderType;
import alararestaurant.repository.EmployeeRepository;
import alararestaurant.repository.ItemRepository;
import alararestaurant.repository.OrderRepository;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import alararestaurant.util.XmlParser;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private final OrderRepository orderRepository;
    @Autowired
    private final FileUtil fileUtil;
    @Autowired
    private final Gson gson;
    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private final ValidationUtil validationUtil;
    @Autowired
    private final EmployeeRepository employeeRepository;
    @Autowired
    private final ItemRepository itemRepository;

    @Autowired
    private final XmlParser xmlParser;

    public OrderServiceImpl(OrderRepository orderRepository, FileUtil fileUtil, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, EmployeeRepository employeeRepository, ItemRepository itemRepository, XmlParser xmlParser) {
        this.orderRepository = orderRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.employeeRepository = employeeRepository;
        this.itemRepository = itemRepository;
        this.xmlParser = xmlParser;
    }

    @Override
    public Boolean ordersAreImported() {
        return this.orderRepository.count() > 0;
    }

    @Override
    public String readOrdersXmlFile() {
        return fileUtil.readFile(FileImportPaths.ORDERS_IMPORT_PATH);
    }

    @Override
    public String importOrders() {
        StringBuilder result = new StringBuilder();
        try {
            OrdersImportDto ordersImportDto = xmlParser.convertFromFile(FileImportPaths.ORDERS_IMPORT_PATH,
                    OrdersImportDto.class);

            List<Order> orders = ordersImportDto.getOrders()
                    .stream()
                    .map(orderImportDto -> {
                        Order mappedOrder = modelMapper
                                .map(orderImportDto, Order.class);
                        mappedOrder.setEmployee(employeeRepository
                                .findByName(orderImportDto.getEmployee()));
                        mappedOrder.setDateTime(LocalDateTime.parse(
                                orderImportDto.getDateTime(),
                                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
                        mappedOrder.setOrderType(OrderType.valueOf(orderImportDto.getType()));

                        List<OrderItem> itemList = orderImportDto.getItems()
                                .stream()
                                .map(itemImportDto -> {
                                    OrderItem mappedItem = modelMapper
                                            .map(itemImportDto, OrderItem.class);
                                    System.out.println();
                                    mappedItem.setItem(itemRepository
                                            .findByName(itemImportDto.getName()));

                                    return mappedItem;
                                }).collect(Collectors.toList());

                        mappedOrder.setOrderItems(new LinkedHashSet<>(itemList));
                        return mappedOrder;
                    }).collect(Collectors.toList());
            for (Order order : orders) {
                if (validationUtil.isValid(order)) {
                    result.append(String.format("Order for %s on %s added",
                            order.getEmployee().getName(),
                            order.getDateTime().toString()));
                } else {
                    result.append("Invalid data format.");
                }
                result.append(System.lineSeparator());
            }
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public String exportOrdersFinishedByTheBurgerFlippers() {
        // TODO : Implement me
        return "";
    }
}
