package com.example.practicahumberto;

import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class InfoFragmentActivity extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_info_fragment,container,false);
        //Guardar las propiedades de los views en variables de java
        final TextInputLayout textInputLayoutMsg =  view.findViewById(R.id.TextInputLayoutMsg);
        final TextInputEditText textInputLayoutEditMsg =  view.findViewById(R.id.TextInputEditTextMsg);
        final TextInputLayout textInputLayoutEmail =  view.findViewById(R.id.TextInputLayoutEmail2);
        final TextInputEditText textInputEditLayoutEmail =  view.findViewById(R.id.TextInputEditTextEmail2);
        MaterialButton materialButton = view.findViewById(R.id.next_button);

        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Validar(textInputLayoutEditMsg.getText())){
                    textInputLayoutMsg.setError("El campo no puede permanecer vacío");
                }
                if (!Validar(textInputEditLayoutEmail.getText())){
                    textInputLayoutEmail.setError("Debes ingresar un email");
                }
            }
        });
        textInputEditLayoutEmail.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (Validar(textInputEditLayoutEmail.getText())){
                    textInputLayoutEmail.setError(null);
                }
                return false;
            }
        });
        textInputLayoutEditMsg.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (Validar(textInputLayoutEditMsg.getText())){
                    textInputLayoutMsg.setError(null);
                }
                return false;
            }
        });
        return view;
    }
    public boolean Validar(Editable entrada){
        return entrada != null;

    }
}
