package ohtu;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;

public class Submission {

    private String student_number;
    private String tasksDone;
    private int timeSpent;
    private StringBuilder tasks;
    private String week;
    private String hours;
    private String a1;
    private String a2;
    private String a3;
    private String a4;
    private String a5;
    private String a6;
    private String a7;
    private String a8;
    private String a9;
    private String a10;
    private String a11;
    private String a12;
    private String a13;
    private int numberOfTasks;

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getStudent_number() {
        return student_number;
    }

    public String getTasksDone() {
        return tasksDone;
    }

    public void setTasksDone(String tasksDone) {
        this.tasksDone = tasksDone;
    }


    public StringBuilder getTasks() {
        return tasks;
    }

    public void setTasks(StringBuilder tasks) {
        this.tasks = tasks;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    @Override
    public String toString() {
        checkTasks();
        return "viikko " + this.week + ": " + "aikaa kului " + this.hours + " tuntia. Tehtyjä tehtäviä yhteensä: " + numberOfTasks +" Tehdyt tehtävät: " + tasks.toString();
    }
    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    public int getNumberOfTasks() {
        return numberOfTasks;
    }

//    void parse(String bodyText) {
//        JsonElement jelement = new JsonParser().parse(bodyText);
//        JsonObject jobject = jelement.getAsJsonObject();
//        jobject = jobject.getAsJsonObject("week");
//        JsonArray jarray = jobject.getAsJsonArray("week");
    public void setNumberOfTasks(int numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
    }

//        jobject = jarray.get(0).getAsJsonObject();
//        this.week = jobject.get("week").toString();
//        
//    }
    private void checkTasks() {
        this.tasks = new StringBuilder();
        if (a1.equals("true")) {
            this.tasks.append("1 ");
            numberOfTasks++;
        }
        if (a2.equals("true")) {
            this.tasks.append("2 ");
            numberOfTasks++;
        }
        if (a3.equals("true")) {
            this.tasks.append("3 ");
            numberOfTasks++;
        }
        if (a4.equals("true")) {
            this.tasks.append("4 ");
            numberOfTasks++;
        }
        if (a5.equals("true")) {
            this.tasks.append("5 ");
            numberOfTasks++;
        }
        if (a6.equals("true")) {
            this.tasks.append("6 ");
            numberOfTasks++;
        }
        if (a7.equals("true")) {
            this.tasks.append("7 ");
            numberOfTasks++;
        }
        if (a8 != null && a8.equals("true")) {
            this.tasks.append("8 ");
            numberOfTasks++;
        }
        if (a9 != null && a9.equals("true")) {
            this.tasks.append("9 ");
            numberOfTasks++;
        }
        if (a10 != null && a10.equals("true")) {
            this.tasks.append("10 ");
            numberOfTasks++;
        }
        if ( a11 != null && a11.equals("true") ) {
            this.tasks.append("11 ");
            numberOfTasks++;
        }
        if (a12 != null && a12.equals("true") ) {
            this.tasks.append("12 ");
            numberOfTasks++;
        }
        if (a13 != null && a13.equals("true") ) {
            this.tasks.append("13 ");
            numberOfTasks++;
        }
    }

}
