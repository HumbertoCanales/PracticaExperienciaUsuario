package com.example.practicahumberto;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginFragmentActivity extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_loginfragment,container,false);
        //Guardar las propiedades de los views en variables de java
        final TextInputLayout textInputLayoutPswd =  view.findViewById(R.id.TextInputLayoutPswd);
        final TextInputEditText textInputLayoutEditPswd =  view.findViewById(R.id.TextInputEditTextPswd);
        final TextInputLayout textInputLayoutEmail =  view.findViewById(R.id.TextInputLayoutEmail);
        final TextInputEditText textInputEditLayoutEmail =  view.findViewById(R.id.TextInputEditTextEmail);
        MaterialButton materialButton = view.findViewById(R.id.next_button);

        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Validar(textInputLayoutEditPswd.getText())){
                    textInputLayoutPswd.setError("Debe ser mayor a 6 caracteres");
                }
                if (!EmailValido(textInputEditLayoutEmail.getText())){
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
        textInputLayoutEditPswd.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (Validar(textInputLayoutEditPswd.getText())){
                    textInputLayoutPswd.setError(null);
                }
                return false;
            }
        });
        return view;
    }
    public boolean Validar(Editable entrada){
        return entrada != null && entrada.length() > 6;

    }

    public boolean EmailValido(Editable entrada){
        return entrada != null;

    }
}
