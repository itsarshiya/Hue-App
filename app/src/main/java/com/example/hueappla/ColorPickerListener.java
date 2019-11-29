package com.example.hueappla;

public interface ColorPickerListener {

    void OnHueChanged(int hue);
    void OnBriChanged(int bri);
    void OnSatChanged(int sat);
    void OnOnChanged(boolean on);

}
