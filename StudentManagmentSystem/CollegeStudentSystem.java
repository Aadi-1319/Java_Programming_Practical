import java.time.Year;

class Student {
    static Student[] studentList = new Student[20];
    static int counterIT = 0;
    static int counterCSE = 0;
    static int counterECE = 0;
    static int counterME = 0;
    static int counterCH = 0;
    static int counterTX = 0;

    String stuEmail;
    String stuName;
    String stuReg;
    String stuBlood;
    int stuYear;
    String stuBranch;
    int stuAdmissionYear;
    String stuMode;

    void assignName(String nm) {
        this.stuName = nm;
    }

    void assignBlood(String bg) {
        this.stuBlood = bg;
    }

    void assignEmail(String reg) {
        this.stuEmail = reg + "@sggs.ac.in";
    }

    void assignCurrentYear(int startYear) {
        this.stuYear = (Year.now().getValue() - startYear) + 1;
    }

    void assignAdmissionYear(int year) {
        this.stuAdmissionYear = year;
    }

    void assignBranch(String dept) {
        this.stuBranch = dept;
    }

    void assignMode(String entryMode) {
        this.stuMode = entryMode;
    }
     void assignReg() {
        String deptCode = this.stuBranch.substring(0, 2).toUpperCase();
        int idCount = 0;

        if (deptCode.equals("C")) {
            idCount = ++counterCSE;
        } else if (deptCode.equals("E")) {
            idCount = ++counterECE;
        } else if (deptCode.equals("I")) {
            idCount = ++counterIT;
        } else if (deptCode.equals("M")) {
            idCount = ++counterME;
        } else if (deptCode.equals("T")) {
            idCount = ++counterTX;
        } else {
            idCount = ++counterCH;
        }

        if (stuMode.equals("DSY")) {
            idCount = 500 + idCount;
            this.stuReg = this.stuAdmissionYear + "B" + deptCode + idCount;
        } else {
            this.stuReg = this.stuAdmissionYear + "B" + deptCode + "0" + idCount;
        }
        assignEmail(stuReg);
    }

    void processInput(String rawData) {
        String[] records = rawData.split("#");
        int totalStudents = records.length;

        for (int idx = 0; idx < totalStudents; idx++) {
            String[] fields = records[idx].split(",");
            Student temp = new Student();
            for (String entry : fields) {
                entry = entry.trim();
                if (entry.startsWith("Name=")) {
                    temp.assignName(entry.substring(5));
                } else if (entry.startsWith("Branch=")) {
                    temp.assignBranch(entry.substring(7));
                } else if (entry.startsWith("BloodGroup=")) {
                    temp.assignBlood(entry.substring(11));
                } else if (entry.startsWith("AdmissionYear=")) {
                    temp.assignAdmissionYear(Integer.parseInt(entry.substring(14)));
                } else if (entry.startsWith("Mode=")) {
                    temp.assignMode(entry.substring(5));
                }
            }
            temp.assignReg();
            temp.assignCurrentYear(temp.stuAdmissionYear);
            studentList[idx] = temp;
        }
    }

    void displayInfo() {
        System.out.println("Name: " + stuName);
        System.out.println("Email: " + stuEmail);
        System.out.println("RegNo: " + stuReg);
        System.out.println("Blood Group: " + stuBlood);
        System.out.println("Current Year: " + stuYear);
        System.out.println("Branch: " + stuBranch);
        System.out.println("Admission Year: " + stuAdmissionYear);
        System.out.println("Mode: " + stuMode);
    }

    public static void main(String[] args) {
        Student handler = new Student();
        handler.processInput("Name:ADITYA GHUGE,Branch=IT,BloodGroup=A+,AdmissionYear=2022,Mode=DSY #Name=RAJ BHAI,Branch=MECH,BloodGroup=B+,AdmissionYear=2025,Mode=Regular #Name=KUSHAL MEHAR,Branch=CSE,BloodGroup=A+,AdmissionYear=2024,Mode=Regular");
        for (Student obj : studentList) {
            if (obj != null) {
                obj.displayInfo();
                System.out.println();
            }
        }
    }
}

