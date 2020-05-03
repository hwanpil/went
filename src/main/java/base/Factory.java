package base;

import java.util.List;

public interface Factory {
    void run();
    List<Component> getAllComponents();
    void test();
}
