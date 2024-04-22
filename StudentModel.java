package com.example.studentmanagement;

public class StudentModel {
        private String firstname;
        private String lastname;
        private String email;
        private String course;
        private int age;

        public StudentModel(String firstname, String lastname, String email, String course, int age){
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
            this.course = course;
            this.age = age;
        }
        public String getFirstName() {
            return firstname;
        }
        public String getLastName() {
            return lastname;
        }
        public String getEmail() {
            return email;
        }

        public String getCourse() {
            return course;
        }

        public int getAge() {
            return age;
        }
}
