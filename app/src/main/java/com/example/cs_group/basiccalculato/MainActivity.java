package com.example.cs_group.basiccalculato;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //     when an variable get completed will save in this ArrayList
    public static ArrayList<String> variables = new ArrayList<>();

    //     operator commands will save in this ArrayList ( usage : Equal method )
    public static ArrayList<String> operations = new ArrayList<>();

    //    Declare All of views
    EditText et;
    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, btPoint, btClear,
            btAddition, btSubtraction, btMultiplication, btDivision, btEqual;

    boolean equalEffect = false;// button effect on reaction of buttons when tapping them

    String TempVariable = "";// this variable get updated till user input an operator

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeAllOfViews();// initialize All Of Buttons, editText
        setListenerForNumbersButton();//set OnClickListener method for bt0 to bt 9 and btPoint

        //set OnClickListener method for btAddiction,btSubtraction, btMultiplication, btDivision,btClear, btEqual
        setListenerForOperationButton();
    }

    private void setListenerForOperationButton() {
        btAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equalEffect) {
                    variables.add(et.getText().toString());
                } else {
                    variables.add(TempVariable);
                }
                et.setText(et.getText() + "+");
                operations.add("plus");
                TempVariable = "";
                equalEffect = false;
            }
        });

        btSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "-");
                if (equalEffect) {
                    variables.add(et.getText().toString());
                } else {
                }
                variables.add(TempVariable);
                operations.add("minus");
                TempVariable = "";
                equalEffect = false;
            }
        });

        btMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "×");
                if (equalEffect) {
                    variables.add(et.getText().toString());
                } else {
                    variables.add(TempVariable);
                }
                operations.add("multiple");
                TempVariable = "";
                equalEffect = false;
            }
        });

        btDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "÷");
                if (equalEffect) {
                    variables.add(et.getText().toString());
                } else {
                    variables.add(TempVariable);
                }
                operations.add("division");
                TempVariable = "";
                equalEffect = false;
            }
        });
        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                variables.clear();
                operations.clear();
                et.setText("");
                equalEffect = false;
            }
        });
        btEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                variables.add(TempVariable);
                TempVariable = "";

                for (int i = 0; i < operations.size(); i++) {
                    if (variables.size() == 0)
                        et.setText("");
                    if (variables.size() == 1)
                        et.setText(variables.get(0));
                    String ops = operations.get(i);

                    switch (ops) {
                        case "multiple":
                            Refactor(operations.indexOf(ops), Multiple(operations.indexOf(ops)));
                            i--;
                            break;
                        case "division":
                            Refactor(operations.indexOf(ops), Division(operations.indexOf(ops)));
                            i--;
                            break;
                    }
                }
                for (int i = 0; i < operations.size(); i++) {
                    if (variables.size() == 0)
                        et.setText("");
                    if (variables.size() == 1)
                        et.setText(variables.get(0));
                    String ops = operations.get(i);

                    switch (ops) {
                        case "plus":
                            Refactor(operations.indexOf(ops), Plus(operations.indexOf(ops)));
                            i--;
                            break;
                        case "minus":
                            Refactor(operations.indexOf(ops), Minus(operations.indexOf(ops)));
                            i--;
                            break;
                    }
                }
                et.setText(variables.get(0));
                operations.clear();
                variables.clear();
                equalEffect = true;
            }
        });
    }

    public String Plus(int indexOfOperation) {
        double result = Double.parseDouble(variables.get(indexOfOperation)) + Double.parseDouble(variables.get(indexOfOperation + 1));
        return Double.toString(result);
    }

    public String Minus(int indexOfOperation) {
        double result = Double.parseDouble(variables.get(indexOfOperation)) - Double.parseDouble(variables.get(indexOfOperation + 1));
        return Double.toString(result);
    }

    public String Multiple(int indexOfOperation) {
        double result = Double.parseDouble(variables.get(indexOfOperation)) * Double.parseDouble(variables.get(indexOfOperation + 1));
        return Double.toString(result);
    }

    public String Division(int indexOfOperation) {
        double result = Double.parseDouble(variables.get(indexOfOperation)) / Double.parseDouble(variables.get(indexOfOperation + 1));
        return Double.toString(result);
    }

    //  After Executing each operation, Refactor method will place Result in index 0 of Variables ArrayList
    // and
    // will delete Second variable in Variables ArrayList
    public void Refactor(int indexOfOperation, String result) {
        variables.set(indexOfOperation, result);
        variables.remove(indexOfOperation + 1);
        operations.remove(indexOfOperation);
    }

    private void setListenerForNumbersButton() {
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "1");
                TempVariable += "1";

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "2");
                TempVariable += "2";

            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "3");
                TempVariable += "3";

            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "4");
                TempVariable += "4";

            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "5");
                TempVariable += "5";

            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "6");
                TempVariable += "6";

            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "7");
                TempVariable += "7";

            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "8");
                TempVariable += "8";

            }
        });

        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "9");
                TempVariable += "9";

            }
        });

        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "0");
                TempVariable += "0";
            }
        });

        btPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + ".");
                TempVariable += ".";
            }
        });

    }

    private void initializeAllOfViews() {
        et = findViewById(R.id.editTextView);
        bt0 = findViewById(R.id.button0);
        bt1 = findViewById(R.id.button1);
        bt2 = findViewById(R.id.button2);
        bt3 = findViewById(R.id.button3);
        bt4 = findViewById(R.id.button4);
        bt5 = findViewById(R.id.button5);
        bt6 = findViewById(R.id.button6);
        bt7 = findViewById(R.id.button7);
        bt8 = findViewById(R.id.button8);
        bt9 = findViewById(R.id.button9);
        btEqual = findViewById(R.id.buttonEqual);
        btClear = findViewById(R.id.buttonClear);
        btPoint = findViewById(R.id.buttonPoint);
        btDivision = findViewById(R.id.buttonDivision);
        btAddition = findViewById(R.id.buttonAddiction);
        btSubtraction = findViewById(R.id.buttonSubtraction);
        btMultiplication = findViewById(R.id.buttonMultiplication);
    }
}
