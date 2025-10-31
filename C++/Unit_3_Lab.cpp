#include <iostream>
using namespace std;

int main() {
    int choice;
    char again;

    do {
        cout << "\n\n=== LAB ACTIVITIES MENU ===\n";
        cout << "1. Calculate Speed of an Object\n";
        cout << "2. Newton\'s Second Law (F = m * a)\n";
        cout << "3. Calculate Acceleration (a = (vf - vi) / t)\n";
        cout << "4. Area of a Triangle\n";
        cout << "5. Convert Celsius to Fahrenheit\n";
        cout << "6. Volume of a Box\n";
        cout << "7. Marksheet (Total & Percentage)\n";
        cout << "8. Expression: a^2 + 2ab + b^2\n";
        cout << "9. Square of a Number\n";
        cout << "Enter your choice (1-9): ";
        cin >> choice;

        cout << endl;

        switch (choice) {
            case 1: {
                float distance, time, speed;
                cout << "Enter distance (m): ";
                cin >> distance;
                cout << "Enter time (s): ";
                cin >> time;
                speed = distance / time;
                cout << "Speed = " << speed << " m/s";
                break;
            }

            case 2: {
                float m, a, F;
                cout << "Enter mass (kg): ";
                cin >> m;
                cout << "Enter acceleration (m/s^2): ";
                cin >> a;
                F = m * a;
                cout << "Force = " << F << " N";
                break;
            }

            case 3: {
                float vi, vf, t, acc;
                cout << "Enter initial velocity (vi): ";
                cin >> vi;
                cout << "Enter final velocity (vf): ";
                cin >> vf;
                cout << "Enter time (t): ";
                cin >> t;
                acc = (vf - vi) / t;
                cout << "Acceleration = " << acc << " m/s^2";
                break;
            }

            case 4: {
                float base, height, area;
                cout << "Enter base: ";
                cin >> base;
                cout << "Enter height: ";
                cin >> height;
                area = 0.5 * base * height;
                cout << "Area of Triangle = " << area;
                break;
            }

            case 5: {
                float c, f;
                cout << "Enter temperature in Celsius: ";
                cin >> c;
                f = (c * 1.8) + 32;
                cout << "Temperature in Fahrenheit = " << f;
                break;
            }

            case 6: {
                float l, w, h, volume;
                cout << "Enter length: ";
                cin >> l;
                cout << "Enter width: ";
                cin >> w;
                cout << "Enter height: ";
                cin >> h;
                volume = l * w * h;
                cout << "Volume of Box = " << volume;
                break;
            }

            case 7: {
                float s1, s2, s3, s4, s5, total, percent;
                cout << "Enter marks of 5 subjects: ";
                cin >> s1 >> s2 >> s3 >> s4 >> s5;
                total = s1 + s2 + s3 + s4 + s5;
                percent = (total / 500) * 100;
                cout << "Total Marks = " << total << endl;
                cout << "Percentage = " << percent << "%";
                break;
            }

            case 8: {
                int a, b, result;
                cout << "Enter value of a: ";
                cin >> a;
                cout << "Enter value of b: ";
                cin >> b;
                result = (a * a) + (2 * a * b) + (b * b);
                cout << "Result of a^2 + 2ab + b^2 = " << result;
                break;
            }

            case 9: {
                int x;
                cout << "Enter value of x: ";
                cin >> x;
                cout << "Square of x = " << x * x;
                break;
            }

            default:
                cout << "Invalid choice!";
        }

        cout << "\n\nDo you want to perform another operation? (y/n): ";
        cin >> again;

    } while (again == 'y' || again == 'Y');

    cout << "\nThank you for using the Lab Activities Program!";
    return 0;
}