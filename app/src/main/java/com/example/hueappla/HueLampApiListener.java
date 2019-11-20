package com.example.hueappla;

public interface HueLampApiListener {

    void OnHueLampAvailable(HueLamp hueLamp);
    void OnHueAdapterError();

}
