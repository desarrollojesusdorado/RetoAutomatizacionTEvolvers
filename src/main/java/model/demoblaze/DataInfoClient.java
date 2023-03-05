package model.demoblaze;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataInfoClient {
    private String name;
    private String country;
    private String city;
    private String creditCard;
    private String month;
    private String year;
}
