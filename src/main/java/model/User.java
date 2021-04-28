package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private String address;

    private String phone;
}
