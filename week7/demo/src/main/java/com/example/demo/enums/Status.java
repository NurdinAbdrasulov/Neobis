package com.example.demo.enums;

/**
 * Статус покупок, заказов
 */
public enum Status {
    SUCCESS,// успешно
    FAIL,// провал (форс мажор)
    CANCELED,//отменен пользователем или фирмой
    IN_PROCESS;// в процессе
}
