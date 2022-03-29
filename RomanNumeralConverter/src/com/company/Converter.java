package com.company;

import java.util.Locale;

public class Converter {

    private String resultingRomanNumeral;
    private int resultingDecimalNum;
    private final String inputString;
    private int stringIndex;

    private boolean valid;

    public Converter(String inputString, boolean isDecimal) {
        this.inputString = inputString.toUpperCase(Locale.ROOT);
        valid = true;
        resultingRomanNumeral = "";
        resultingDecimalNum = 0;

        if (isDecimal) {
            decToRomanNum();
        } else {
            romanNumeralToDec();
        }
    }

    public boolean isValid() {
        return valid;
    }

    public String getResultingRomanNumeral() {
        return resultingRomanNumeral;
    }

    public int getResultingDecimalNum() {
        return resultingDecimalNum;
    }

    private void romanNumeralToDec() {
        stringIndex = 0;
        state0();
    }

    //States 0 through 12 represent a finite state automaton to traverse and interpret the given
    // Roman Numeral string

    private void state0() {
        if (stringIndex >= inputString.length()) {
            return;
        }
        if (inputString.charAt(stringIndex) == 'M') {
            stringIndex++;
            resultingDecimalNum += 1000;
            state1();
        } else if (inputString.charAt(stringIndex) == 'D') {
            stringIndex++;
            resultingDecimalNum += 500;
            state4();
        } else if (inputString.charAt(stringIndex) == 'C') {
            if (stringIndex + 1 < inputString.length()) {
                if (inputString.charAt(stringIndex + 1) == 'D') {
                    stringIndex += 2;
                    resultingDecimalNum += 400;
                    state6();
                } else if (inputString.charAt(stringIndex + 1) == 'M') {
                    stringIndex += 2;
                    resultingDecimalNum += 900;
                    state6();
                } else {
                    stringIndex++;
                    resultingDecimalNum += 100;
                    state5();
                }
            } else {
                stringIndex++;
                resultingDecimalNum += 100;
                state12();
            }
        } else if (inputString.charAt(stringIndex) == 'L') {
            stringIndex++;
            resultingDecimalNum += 50;
            state7();
        } else if (inputString.charAt(stringIndex) == 'X') {
            if (stringIndex + 1 < inputString.length()) {
                if (inputString.charAt(stringIndex + 1) == 'C') {
                    stringIndex += 2;
                    resultingDecimalNum += 90;
                    state9();
                } else if (inputString.charAt(stringIndex + 1) == 'L') {
                    stringIndex += 2;
                    resultingDecimalNum += 40;
                    state9();
                } else {
                    stringIndex++;
                    resultingDecimalNum += 10;
                    state8();
                }
            } else {
                stringIndex++;
                resultingDecimalNum += 10;
                state12();
            }
        } else if (inputString.charAt(stringIndex) == 'V') {
            stringIndex++;
            resultingDecimalNum += 5;
            state10();
        } else if (inputString.charAt(stringIndex) == 'I') {
            if (stringIndex + 1 < inputString.length()) {
                if (inputString.charAt(stringIndex + 1) == 'X') {
                    stringIndex += 2;
                    resultingDecimalNum += 9;
                    state12();
                } else if (inputString.charAt(stringIndex + 1) == 'V') {
                    stringIndex += 2;
                    resultingDecimalNum += 4;
                    state12();
                } else {
                    stringIndex++;
                    resultingDecimalNum++;
                    state11();
                }
            } else {
                stringIndex++;
                resultingDecimalNum++;
                state12();
            }
        } else {
            valid = false;
        }
    }

    private void state1() {
        if (stringIndex >= inputString.length()) {
            return;
        }
        if (inputString.charAt(stringIndex) == 'M') {
            stringIndex++;
            resultingDecimalNum += 1000;
            state2();
        } else if (inputString.charAt(stringIndex) == 'D') {
            stringIndex++;
            resultingDecimalNum += 500;
            state4();
        } else if (inputString.charAt(stringIndex) == 'C') {
            if (stringIndex + 1 < inputString.length()) {
                if (inputString.charAt(stringIndex + 1) == 'D') {
                    stringIndex += 2;
                    resultingDecimalNum += 400;
                    state6();
                } else if (inputString.charAt(stringIndex + 1) == 'M') {
                    stringIndex += 2;
                    resultingDecimalNum += 900;
                    state6();
                } else {
                    stringIndex++;
                    resultingDecimalNum += 100;
                    state6();
                }
            } else {
                stringIndex++;
                resultingDecimalNum += 100;
                state12();
            }
        } else if (inputString.charAt(stringIndex) == 'L') {
            stringIndex++;
            resultingDecimalNum += 50;
            state7();
        } else if (inputString.charAt(stringIndex) == 'X') {
            if (stringIndex + 1 < inputString.length()) {
                if (inputString.charAt(stringIndex + 1) == 'C') {
                    stringIndex += 2;
                    resultingDecimalNum += 90;
                    state9();
                } else if (inputString.charAt(stringIndex + 1) == 'L') {
                    stringIndex += 2;
                    resultingDecimalNum += 40;
                    state9();
                } else {
                    stringIndex++;
                    resultingDecimalNum += 10;
                    state8();
                }
            } else {
                stringIndex++;
                resultingDecimalNum += 10;
                state12();
            }
        } else if (inputString.charAt(stringIndex) == 'V') {
            stringIndex++;
            resultingDecimalNum += 5;
            state10();
        } else if (inputString.charAt(stringIndex) == 'I') {
            if (stringIndex + 1 < inputString.length()) {
                if (inputString.charAt(stringIndex + 1) == 'X') {
                    stringIndex += 2;
                    resultingDecimalNum += 9;
                    state12();
                } else if (inputString.charAt(stringIndex + 1) == 'V') {
                    stringIndex += 2;
                    resultingDecimalNum += 4;
                    state12();
                } else {
                    stringIndex++;
                    resultingDecimalNum++;
                    state11();
                }
            } else {
                stringIndex++;
                resultingDecimalNum++;
                state12();
            }
        } else {
            valid = false;
        }
    }

    private void state2() {
        if (stringIndex >= inputString.length()) {
            return;
        }
        if (inputString.charAt(stringIndex) == 'M') {
            stringIndex++;
            resultingDecimalNum += 1000;
            state3();
        } else if (inputString.charAt(stringIndex) == 'D') {
            stringIndex++;
            resultingDecimalNum += 500;
            state4();
        } else if (inputString.charAt(stringIndex) == 'C') {
            if (stringIndex + 1 < inputString.length()) {
                if (inputString.charAt(stringIndex + 1) == 'D') {
                    stringIndex += 2;
                    resultingDecimalNum += 400;
                    state6();
                } else if (inputString.charAt(stringIndex + 1) == 'M') {
                    stringIndex += 2;
                    resultingDecimalNum += 900;
                    state6();
                } else {
                    stringIndex++;
                    resultingDecimalNum += 100;
                    state6();
                }
            } else {
                stringIndex++;
                resultingDecimalNum += 100;
                state12();
            }
        } else if (inputString.charAt(stringIndex) == 'L') {
            stringIndex++;
            resultingDecimalNum += 50;
            state7();
        } else if (inputString.charAt(stringIndex) == 'X') {
            if (stringIndex + 1 < inputString.length()) {
                if (inputString.charAt(stringIndex + 1) == 'C') {
                    stringIndex += 2;
                    resultingDecimalNum += 90;
                    state9();
                } else if (inputString.charAt(stringIndex + 1) == 'L') {
                    stringIndex += 2;
                    resultingDecimalNum += 40;
                    state9();
                } else {
                    stringIndex++;
                    resultingDecimalNum += 10;
                    state8();
                }
            } else {
                stringIndex++;
                resultingDecimalNum += 10;
                state12();
            }
        } else if (inputString.charAt(stringIndex) == 'V') {
            stringIndex++;
            resultingDecimalNum += 5;
            state10();
        } else if (inputString.charAt(stringIndex) == 'I') {
            if (stringIndex + 1 < inputString.length()) {
                if (inputString.charAt(stringIndex + 1) == 'X') {
                    stringIndex += 2;
                    resultingDecimalNum += 9;
                    state12();
                } else if (inputString.charAt(stringIndex + 1) == 'V') {
                    stringIndex += 2;
                    resultingDecimalNum += 4;
                    state12();
                } else {
                    stringIndex++;
                    resultingDecimalNum++;
                    state11();
                }
            } else {
                stringIndex++;
                resultingDecimalNum++;
                state12();
            }
        } else {
            valid = false;
        }
    }

    private void state3() {
        if (stringIndex >= inputString.length()) {
            return;
        }
        if (inputString.charAt(stringIndex) == 'D') {
            stringIndex++;
            resultingDecimalNum += 500;
            state4();
        } else if (inputString.charAt(stringIndex) == 'C') {
            if (stringIndex + 1 < inputString.length()) {
                if (inputString.charAt(stringIndex + 1) == 'M') {
                    stringIndex += 2;
                    resultingDecimalNum += 900;
                    state6();
                }
                else if (inputString.charAt(stringIndex + 1) == 'D') {
                    stringIndex += 2;
                    resultingDecimalNum += 400;
                    state6();
                } else {
                    stringIndex++;
                    resultingDecimalNum += 100;
                    state5();
                }
            } else {
                stringIndex++;
                resultingDecimalNum += 100;
                state12();
            }
        } else if (inputString.charAt(stringIndex) == 'L') {
            stringIndex++;
            resultingDecimalNum += 50;
            state7();
        } else if (inputString.charAt(stringIndex) == 'X') {
            if (stringIndex + 1 < inputString.length()) {
                if (inputString.charAt(stringIndex + 1) == 'C') {
                    stringIndex += 2;
                    resultingDecimalNum += 90;
                    state9();
                } else if (inputString.charAt(stringIndex + 1) == 'L') {
                    stringIndex += 2;
                    resultingDecimalNum += 40;
                    state9();
                } else {
                    stringIndex++;
                    resultingDecimalNum += 10;
                    state8();
                }
            } else {
                stringIndex++;
                resultingDecimalNum += 10;
                state12();
            }
        } else if (inputString.charAt(stringIndex) == 'V') {
            stringIndex++;
            resultingDecimalNum += 5;
            state10();
        } else if (inputString.charAt(stringIndex) == 'I') {
            if (stringIndex + 1 < inputString.length()) {
                if (inputString.charAt(stringIndex + 1) == 'X') {
                    stringIndex += 2;
                    resultingDecimalNum += 9;
                    state12();
                } else if (inputString.charAt(stringIndex + 1) == 'V') {
                    stringIndex += 2;
                    resultingDecimalNum += 4;
                    state12();
                } else {
                    stringIndex++;
                    resultingDecimalNum++;
                    state11();
                }
            } else {
                stringIndex++;
                resultingDecimalNum++;
                state12();
            }
        } else {
            valid = false;
        }
    }

    private void state4() {
        if (stringIndex >= inputString.length()) {
            return;
        }
        if (inputString.charAt(stringIndex) == 'C') {
            stringIndex++;
            resultingDecimalNum += 100;
            state5();
        } else if (inputString.charAt(stringIndex) == 'L') {
            stringIndex++;
            resultingDecimalNum += 50;
            state7();
        } else if (inputString.charAt(stringIndex) == 'X') {
            if (stringIndex + 1 < inputString.length()) {
                if (inputString.charAt(stringIndex + 1) == 'C') {
                    stringIndex += 2;
                    resultingDecimalNum += 90;
                    state9();
                } else if (inputString.charAt(stringIndex + 1) == 'L') {
                    stringIndex += 2;
                    resultingDecimalNum += 40;
                    state9();
                } else {
                    stringIndex++;
                    resultingDecimalNum += 10;
                    state8();
                }
            } else {
                stringIndex++;
                resultingDecimalNum += 10;
                state12();
            }
        } else if (inputString.charAt(stringIndex) == 'V') {
            stringIndex++;
            resultingDecimalNum += 5;
            state10();
        } else if (inputString.charAt(stringIndex) == 'I') {
            if (stringIndex + 1 < inputString.length()) {
                if (inputString.charAt(stringIndex + 1) == 'X') {
                    stringIndex += 2;
                    resultingDecimalNum += 9;
                    state12();
                } else if (inputString.charAt(stringIndex + 1) == 'V') {
                    stringIndex += 2;
                    resultingDecimalNum += 4;
                    state12();
                } else {
                    stringIndex++;
                    resultingDecimalNum++;
                    state11();
                }
            } else {
                stringIndex++;
                resultingDecimalNum++;
                state12();
            }
        } else {
            valid = false;
        }
    }

    private void state5() {
        if (stringIndex >= inputString.length()) {
            return;
        }
        if (inputString.charAt(stringIndex) == 'C') {
            if (inputString.charAt(stringIndex + 1) == 'C') {
                stringIndex += 2;
                resultingDecimalNum += 200;
                state6();
            } else {
                stringIndex++;
                resultingDecimalNum += 100;
                state6();
            }
        } else if (inputString.charAt(stringIndex) == 'L') {
            stringIndex++;
            resultingDecimalNum += 50;
            state7();
        } else if (inputString.charAt(stringIndex) == 'X') {
            if (stringIndex + 1 < inputString.length()) {
                if (inputString.charAt(stringIndex + 1) == 'C') {
                    stringIndex += 2;
                    resultingDecimalNum += 90;
                    state9();
                } else if (inputString.charAt(stringIndex + 1) == 'L') {
                    stringIndex += 2;
                    resultingDecimalNum += 40;
                    state9();
                } else {
                    stringIndex++;
                    resultingDecimalNum += 10;
                    state8();
                }
            } else {
                stringIndex++;
                resultingDecimalNum += 10;
                state12();
            }
        } else if (inputString.charAt(stringIndex) == 'V') {
            stringIndex++;
            resultingDecimalNum += 5;
            state10();
        } else if (inputString.charAt(stringIndex) == 'I') {
            if (stringIndex + 1 < inputString.length()) {
                if (inputString.charAt(stringIndex + 1) == 'X') {
                    stringIndex += 2;
                    resultingDecimalNum += 9;
                    state12();
                } else if (inputString.charAt(stringIndex + 1) == 'V') {
                    stringIndex += 2;
                    resultingDecimalNum += 4;
                    state12();
                } else {
                    stringIndex++;
                    resultingDecimalNum++;
                    state11();
                }
            } else {
                stringIndex++;
                resultingDecimalNum++;
                state12();
            }
        } else {
            valid = false;
        }
    }

    private void state6() {
        if (stringIndex >= inputString.length()) {
            return;
        }
        if (inputString.charAt(stringIndex) == 'L') {
            stringIndex++;
            resultingDecimalNum += 50;
            state7();
        } else if (inputString.charAt(stringIndex) == 'X') {
            if (stringIndex + 1 < inputString.length()) {
                if (inputString.charAt(stringIndex + 1) == 'C') {
                    stringIndex += 2;
                    resultingDecimalNum += 90;
                    state9();
                }
                else if (inputString.charAt(stringIndex + 1) == 'L') {
                    stringIndex += 2;
                    resultingDecimalNum += 40;
                    state9();
                } else {
                    stringIndex++;
                    resultingDecimalNum += 10;
                    state8();
                }
            } else {
                stringIndex++;
                resultingDecimalNum += 10;
                state12();
            }
        } else if (inputString.charAt(stringIndex) == 'V') {
            stringIndex++;
            resultingDecimalNum += 5;
            state10();
        } else if (inputString.charAt(stringIndex) == 'I') {
            if (stringIndex + 1 < inputString.length()) {
                if (inputString.charAt(stringIndex + 1) == 'X') {
                    stringIndex += 2;
                    resultingDecimalNum += 9;
                    state12();
                } else if (inputString.charAt(stringIndex + 1) == 'V') {
                    stringIndex += 2;
                    resultingDecimalNum += 4;
                    state12();
                } else {
                    stringIndex++;
                    resultingDecimalNum++;
                    state11();
                }
            } else {
                stringIndex++;
                resultingDecimalNum++;
                state12();
            }
        } else {
            valid = false;
        }
    }

    private void state7() {
        if (stringIndex >= inputString.length()) {
            return;
        }
        if (inputString.charAt(stringIndex) == 'X') {
            stringIndex++;
            resultingDecimalNum += 10;
            state8();
        } else if (inputString.charAt(stringIndex) == 'V') {
            stringIndex++;
            resultingDecimalNum += 5;
            state10();
        } else if (inputString.charAt(stringIndex) == 'I') {
            if (stringIndex + 1 < inputString.length()) {
                if (inputString.charAt(stringIndex + 1) == 'X') {
                    stringIndex += 2;
                    resultingDecimalNum += 9;
                    state12();
                } else if (inputString.charAt(stringIndex + 1) == 'V') {
                    stringIndex += 2;
                    resultingDecimalNum += 4;
                    state12();
                } else {
                    stringIndex++;
                    resultingDecimalNum++;
                    state11();
                }
            } else {
                stringIndex++;
                resultingDecimalNum++;
                state12();
            }
        } else {
            valid = false;
        }
    }

    private void state8() {
        if (stringIndex >= inputString.length()) {
            return;
        }
        if (inputString.charAt(stringIndex) == 'X') {
            if (inputString.charAt(stringIndex + 1) == 'X') {
                stringIndex += 2;
                resultingDecimalNum += 20;
                state9();
            } else {
                stringIndex++;
                resultingDecimalNum += 10;
                state9();
            }
        } else if (inputString.charAt(stringIndex) == 'V') {
            stringIndex++;
            resultingDecimalNum += 5;
            state10();
        } else if (inputString.charAt(stringIndex) == 'I') {
            if (stringIndex + 1 < inputString.length()) {
                if (inputString.charAt(stringIndex + 1) == 'X') {
                    stringIndex += 2;
                    resultingDecimalNum += 9;
                    state12();
                } else if (inputString.charAt(stringIndex + 1) == 'V') {
                    stringIndex += 2;
                    resultingDecimalNum += 4;
                    state12();
                } else {
                    stringIndex++;
                    resultingDecimalNum++;
                    state11();
                }
            } else {
                stringIndex++;
                resultingDecimalNum++;
                state12();
            }
        } else {
            valid = false;
        }
    }

    private void state9() {
        if (stringIndex >= inputString.length()) {
            return;
        }
        if (inputString.charAt(stringIndex) == 'V') {
            stringIndex++;
            resultingDecimalNum += 5;
            state10();
        } else if (inputString.charAt(stringIndex) == 'I') {
            if (stringIndex + 1 < inputString.length()) {
                if (inputString.charAt(stringIndex + 1) == 'X') {
                    stringIndex += 2;
                    resultingDecimalNum += 9;
                    state12();
                }
                else if (inputString.charAt(stringIndex + 1) == 'V') {
                    stringIndex += 2;
                    resultingDecimalNum += 4;
                    state12();
                } else {
                    stringIndex++;
                    resultingDecimalNum++;
                    state11();
                }
            } else {
                stringIndex++;
                resultingDecimalNum++;
                state12();
            }
        } else {
            valid = false;
        }
    }

    private void state10() {
        if (stringIndex >= inputString.length()) {
            return;
        }
        if (inputString.charAt(stringIndex) == 'I') {
            stringIndex++;
            resultingDecimalNum++;
            state11();
        } else {
            valid = false;
        }
    }

    private void state11() {
        if (stringIndex >= inputString.length()) {
            return;
        }
        if (inputString.charAt(stringIndex) == 'I') {
            if (stringIndex + 1 < inputString.length()) {
                if (inputString.charAt(stringIndex + 1) == 'I') {
                    stringIndex += 2;
                    resultingDecimalNum += 2;
                    state12();
                } else {
                    stringIndex++;
                    resultingDecimalNum++;
                    state12();
                }
            } else {
                stringIndex++;
                resultingDecimalNum++;
                state12();
            }
        } else {
            valid = false;
        }
    }

    private void state12() {
        if (stringIndex < inputString.length()) {
            valid = false;
        }
    }

    private void decToRomanNum() {
        StringBuilder romanNumBuilder = new StringBuilder();
        for (int i = 0; i < inputString.length(); ++i) {
            stringIndex = i;
            getNextRomanNum(romanNumBuilder);
        }
        resultingRomanNumeral = romanNumBuilder.toString();
    }

    private void getNextRomanNum(StringBuilder romanNumBuilder) {

        romanNumBuilder.append(convertDigitToRomanNum(Character.getNumericValue(inputString.charAt(stringIndex)),
                (inputString.length() - stringIndex)));
    }

    private String convertDigitToRomanNum(int digit, int numWeight) {
        if (digit == 0) {
            return "";
        }

        if (numWeight == 4) {
            if (digit == 1) {
                return "M";
            } else if (digit == 2) {
                return "MM";
            } else if (digit == 3) {
                return "MMM";
            }
            //In this case, the maximum digit in the thousandths place is a 3, so not necessary
            // to continue at this digit's weight
        } else if (numWeight == 3) {
            if (digit == 1) {
                return "C";
            } else if (digit == 2) {
                return "CC";
            } else if (digit == 3) {
                return "CCC";
            } else if (digit == 4) {
                return "CD";
            } else if (digit == 5) {
                return "D";
            } else if (digit == 6) {
                return "DC";
            } else if (digit == 7) {
                return "DCC";
            } else if (digit == 8) {
                return "DCCC";
            } else if (digit == 9) {
                return "CM";
            }
        } else if (numWeight == 2) {
            if (digit == 1) {
                return "X";
            } else if (digit == 2) {
                return "XX";
            } else if (digit == 3) {
                return "XXX";
            } else if (digit == 4) {
                return "XL";
            } else if (digit == 5) {
                return "L";
            } else if (digit == 6) {
                return "LX";
            } else if (digit == 7) {
                return "LXX";
            } else if (digit == 8) {
                return "LXXX";
            } else if (digit == 9) {
                return "XC";
            }
        } else if (numWeight == 1) {
            if (digit == 1) {
                return "I";
            } else if (digit == 2) {
                return "II";
            } else if (digit == 3) {
                return "III";
            } else if (digit == 4) {
                return "IV";
            } else if (digit == 5) {
                return "V";
            } else if (digit == 6) {
                return "VI";
            } else if (digit == 7) {
                return "VII";
            } else if (digit == 8) {
                return "VIII";
            } else if (digit == 9) {
                return "IX";
            }
        }
        return null;
    }
}
