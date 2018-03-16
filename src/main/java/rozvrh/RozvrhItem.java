package rozvrh;

public class RozvrhItem {

    String course;

    String time;

    String teacher;

    String faculty;

    String room;


    public RozvrhItem(String course, String time, String teacher, String faculty, String room) {
        this.course = course;
        this.time = time;
        this.teacher = teacher;
        this.faculty = faculty;
        this.room = room;
    }

    public String getCourse() {
        return course;
    }

    public String getTime() {
        return time;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "RozvrhItem{" +
                "course='" + course + '\'' +
                ", time='" + time + '\'' +
                ", teacher='" + teacher + '\'' +
                ", faculty='" + faculty + '\'' +
                ", room='" + room + '\'' +
                '}';
    }
}
