package com.tourist.malitourist.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
//cette classe est utiliser lorsqu'on veut se login avec deux attribut username et password mais ce n'est pas une table
    private String username;

    private String password;



}
