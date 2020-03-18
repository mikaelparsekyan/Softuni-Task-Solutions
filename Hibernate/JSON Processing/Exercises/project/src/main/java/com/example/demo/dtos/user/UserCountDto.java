package com.example.demo.dtos.user;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCountDto {

    @Expose
    private int userCount;

    @Expose
    private List<UserProductsExportDto> users = new ArrayList<>();
}
