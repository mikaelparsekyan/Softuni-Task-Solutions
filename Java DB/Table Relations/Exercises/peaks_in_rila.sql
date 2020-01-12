SELECT mountain_range, peak_name, elevation AS peak_elevation
FROM `mountains`, `peaks`
WHERE mountain_range = "Rila" AND mountain_id = 17
ORDER BY peak_elevation DESC;