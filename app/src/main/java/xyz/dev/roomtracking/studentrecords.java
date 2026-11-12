
package xyz.dev.roomtracking;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class studentrecords extends Activity {

    EditText etStudentID, etStudentName, etGradeLevel;
    CheckBox cbActive;

    Button btnAdd, btnUpdate, btnClear;

    TextView tvRecords, tvRecordCount;

    LinearLayout studentCard;
    LinearLayout dragHeader;

    ArrayList<Student> studentList = new ArrayList<>();

    String selectedID = "";

    float startX, startY;
    float cardX, cardY;

    // Student class
    class Student {
        String studentID;
        String studentName;
        String gradeLevel;
        boolean isActive;

        Student(String id, String name, String grade, boolean active) {
            studentID = id;
            studentName = name;
            gradeLevel = grade;
            isActive = active;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentrecords);

        // Connect XML components
        etStudentID = findViewById(R.id.etStudentID);
        etStudentName = findViewById(R.id.etStudentName);
        etGradeLevel = findViewById(R.id.etGradeLevel);

        cbActive = findViewById(R.id.cbActive);

        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnClear = findViewById(R.id.btnClear);

        tvRecords = findViewById(R.id.tvRecords);
        tvRecordCount = findViewById(R.id.tvRecordCount);

        studentCard = findViewById(R.id.studentCard);
        dragHeader = findViewById(R.id.dragHeader);

        // Add student button
        btnAdd.setOnClickListener(v -> addStudent());

        // Update student button
        btnUpdate.setOnClickListener(v -> updateStudent());

        // Clear button
        btnClear.setOnClickListener(v -> clearFields());

        // Select student from list
        tvRecords.setOnClickListener(v -> showStudentList());

        // Enable dragging using the header
        enableDragging();

        displayStudents();
    }

    // ADD STUDENT
    private void addStudent() {

        String id = etStudentID.getText().toString().trim();
        String name = etStudentName.getText().toString().trim();
        String grade = etGradeLevel.getText().toString().trim();
        boolean active = cbActive.isChecked();

        if (id.isEmpty() || name.isEmpty() || grade.isEmpty()) {
            Toast.makeText(this,
                    "Please complete all fields.",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if (findStudent(id) != null) {
            Toast.makeText(this,
                    "Student ID already exists.",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        Student student = new Student(id, name, grade, active);

        studentList.add(student);

        displayStudents();
        clearFields();

        Toast.makeText(this,
                "Student added successfully!",
                Toast.LENGTH_SHORT).show();
    }

    // UPDATE STUDENT
    private void updateStudent() {

        String id = etStudentID.getText().toString().trim();
        String name = etStudentName.getText().toString().trim();
        String grade = etGradeLevel.getText().toString().trim();
        boolean active = cbActive.isChecked();

        if (id.isEmpty() || name.isEmpty() || grade.isEmpty()) {
            Toast.makeText(this,
                    "Please complete all fields.",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        Student student = findStudent(id);

        if (student == null) {
            Toast.makeText(this,
                    "Student not found.",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        student.studentName = name;
        student.gradeLevel = grade;
        student.isActive = active;

        displayStudents();
        clearFields();

        Toast.makeText(this,
                "Student updated successfully!",
                Toast.LENGTH_SHORT).show();
    }

    // FIND STUDENT BY ID
    private Student findStudent(String id) {

        for (Student student : studentList) {

            if (student.studentID.equalsIgnoreCase(id)) {
                return student;
            }
        }

        return null;
    }

    // DISPLAY STUDENT RECORDS
    private void displayStudents() {

        StringBuilder records = new StringBuilder();

        int count = studentList.size();

        if (count == 0) {
            tvRecords.setText("No student records yet.");
        } else {

            for (Student student : studentList) {

                records.append("Student ID: ")
                        .append(student.studentID)
                        .append("\n");

                records.append("Name: ")
                        .append(student.studentName)
                        .append("\n");

                records.append("Grade Level: ")
                        .append(student.gradeLevel)
                        .append("\n");

                records.append("Status: ")
                        .append(student.isActive ? "Active" : "Inactive")
                        .append("\n");

                records.append("-------------------------")
                        .append("\n");
            }

            tvRecords.setText(records.toString());
        }

        tvRecordCount.setText("Total students: " + count);
    }

    // SELECT STUDENT FROM LIST
    private void showStudentList() {

        if (studentList.isEmpty()) {
            Toast.makeText(this,
                    "No student records available.",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        String[] studentNames = new String[studentList.size()];

        for (int i = 0; i < studentList.size(); i++) {

            Student student = studentList.get(i);

            studentNames[i] = student.studentID + " - "
                    + student.studentName;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Select a Student");

        builder.setItems(studentNames, (dialog, which) -> {

            Student student = studentList.get(which);

            etStudentID.setText(student.studentID);
            etStudentName.setText(student.studentName);
            etGradeLevel.setText(student.gradeLevel);

            cbActive.setChecked(student.isActive);

            selectedID = student.studentID;

            Toast.makeText(this,
                    "Student selected.",
                    Toast.LENGTH_SHORT).show();
        });

        builder.setNegativeButton("Cancel", null);

        builder.show();
    }

    // CLEAR INPUT FIELDS
    private void clearFields() {

        etStudentID.setText("");
        etStudentName.setText("");
        etGradeLevel.setText("");

        cbActive.setChecked(true);

        selectedID = "";

        etStudentID.requestFocus();
    }

    // DRAGGABLE STUDENT CARD
    private void enableDragging() {

        dragHeader.setOnTouchListener((view, event) -> {

            switch (event.getAction()) {

                case MotionEvent.ACTION_DOWN:

                    startX = event.getRawX();
                    startY = event.getRawY();

                    cardX = studentCard.getTranslationX();
                    cardY = studentCard.getTranslationY();

                    return true;

                case MotionEvent.ACTION_MOVE:

                    float dx = event.getRawX() - startX;
                    float dy = event.getRawY() - startY;

                    studentCard.setTranslationX(cardX + dx);
                    studentCard.setTranslationY(cardY + dy);

                    return true;

                case MotionEvent.ACTION_UP:

                    view.performClick();
                    return true;
            }

            return false;
        });
    }
}
