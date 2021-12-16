package NullCheck;

class TestEntity {
    public String id;
    public String username;
}

public class TestController {
    private TestService testService;
    private TestOtherService testOtherService;

    public void createTest(TestEntity entity) {
        testService.doSth(entity);
        testOtherService.doSth(entity);

        if (entity.id.equals("NEW_DOCUMENT")) {
            testService.create(entity);
        }
    }
}
