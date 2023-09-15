package com.shoapping.list.ShOAPpingList.infrastructure.exceptionHandler;

public enum ExceptionResponse {
    PRODUCT_NOT_FOUND("No product was found with that Id"),
    PRODUCT_ALREADY_EXISTS("There is already a product with that number"),
    NO_DATA_FOUND("No data found for the requested petition");

    private String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}