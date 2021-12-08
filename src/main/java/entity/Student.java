package main.java.entity;

/**
 * Description
 * 这是作业管理系统的学生实体，基本上信息与mysql的学生表一致，采用注释来跟数据库信息进行交互
 * @author BoldPeanuts
 * @date Created on 2021/12/7
 */
@Table_Name(name = "student")
public class Student {
    @Column_Name(name = "student_name")
    private String name;
    @Column_Name(name = "student_id")
    private String id;
    @Column_Name(name = "student_parents_id")
    private String parentsId;
    @Column_Name(name = "student_class_id")
    private int classId;
    @Column_Name(name = "student_grade")
    private String grade;
    @Column_Name(name = "student_group_id")
    private String groupId;

    public Student(){

    }

    /**
     *
     * @param name 学生姓名
     * @param id 学生的id
     * @param parentsId 学生父母的id
     * @param classId 班级id，方便与班级，老师联系起来
     * @param grade 年级
     */
    public Student(String name, String id, String parentsId, int classId, String connect, String grade){
        this.name = name;
        this.id = id;
        this.parentsId = parentsId;
        this.classId = classId;
        this.grade = grade;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentsId() {
        return parentsId;
    }

    public void setParentsId(String parentsId) {
        this.parentsId = parentsId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     *
     * @return 返回学生信息表示的字符串
     */
    @Override
    public String toString(){
        return "姓名："+this.name+"，年级："+this.grade+"，班级："+this.classId+"，父母id："+this.parentsId+"，学生id："+this.id;
    }

    /**
     * 比较两个对象是否一致
     * @param o 方便所有对象都可以比较
     * @return 一致返回true，否则返回false
     */
    @Override
    public boolean equals(Object o){
        if(o instanceof Student){
            Student s = (Student)o;
            if(name == s.getName() && id == s.getId()){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    /**
     *
     * @return 返回该对象的哈希值
     */
    @Override
    public int hashCode(){
        return name.hashCode()+id.hashCode()+(int)Math.random()*1000;
    }

}
