package com.example.hueappla;

import java.io.Serializable;

public interface HueLampApiListener extends Serializable {

    void OnHueLampAvailable(HueLamp hueLamp);
    void OnHueAdapterError(String error);
    void OnHueLampSetOn(String error, HueLamp hueLamp);
    void OnHueLampSetOnError(String error);
    void OnHueLampSetBri(String error, HueLamp hueLamp);
    void OnHueLampSetBriError(String error);
    void OnHueLampSetSat(String error, HueLamp hueLamp);
    void OnHueLampSetSatError(String error);
    void OnHueLampSetHue(String error, HueLamp hueLamp);
    void OnHueLampSetHueError(String error);

}
