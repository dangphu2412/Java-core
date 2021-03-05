package SerializeExample;

import java.io.Serializable;

public class Human implements Serializable {
    // At first let it 1L then run Writer and run Reader
    // Then change version to 2L now we can t read it because current version is different
    public static final long serialVersionUID = 2L;

    private String name;

    public Human(String name) {
        this.name = name;
    }

    public Human() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
