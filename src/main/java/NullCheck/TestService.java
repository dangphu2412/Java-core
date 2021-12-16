package NullCheck;

import java.util.Collections;
import java.util.List;

public class TestService {
    public List<String> doSth(TestEntity testEntity) {
        if (testEntity.id != null) {
            return Collections.singletonList("asd");
        }
        return null;
    }
    public void create(TestEntity testEntity) {}
}
