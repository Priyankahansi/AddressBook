package com.bridgelabz.DTO;

import com.bridgelabz.entity.AddressBook;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class ResponseDto {
    private String message;
    private Object data;

    public ResponseDto() {
    }

    public ResponseDto(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
