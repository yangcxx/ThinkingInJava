package cn.yangcx.annotation20.database;

/**
 * @author YANGCX
 * @date 2021/9/6 21:21
 */
@DBTable(name = "MEMBER")
public class Member {

    @SQLString(value = 30)
    String firstName;

    @SQLString(value = 50)
    String lastName;

    @SQLInteger
    Integer age;

    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    String handle;

    static int memberCount;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }

    public static int getMemberCount() {
        return memberCount;
    }

    @Override
    public String toString() {
        return handle;
    }
}
