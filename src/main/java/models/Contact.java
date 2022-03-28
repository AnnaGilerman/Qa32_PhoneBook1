package models;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Contact {

    String name;
    String lastName;
    String phoneNumber;
    String email;
    String address;
    String description;

}
