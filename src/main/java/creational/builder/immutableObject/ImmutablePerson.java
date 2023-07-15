package creational.builder.immutableObject;

/**
 * 创建者设计模式可以实现不可变对象，即一旦创建完成，对象的状态就不能改变。
 * 这有助于保证对象的线程安全和数据完整性。
 *
 */
public final class ImmutablePerson {
    //这3个属性是final的，一旦设置则不能更改
    private final String name;
    private final int age;
    private final String address;

    //私有化构造函数，让外界无法直接通过ImmutablePerson类来构建
    //通过 Builder 类的方法来设置属性值，可以选择性地设置需要的属性，而不需要在构造函数中传递一堆参数。这样可以更灵活地构建对象，并且只设置感兴趣的属性。
    //如果在构建 ImmutablePerson 对象时不一次性给外部类的属性赋值，可能会导致 ImmutablePerson 对象处于不完整或不一致的状态。【对象处于无效状态】
    private ImmutablePerson(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "ImmutablePerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder {
        //让创建者再持有一份产品属性副本，方便创建产品时一次性赋值
        private String name;
        private int age;
        private String address;

        public Builder() {
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public ImmutablePerson build() {
            return new ImmutablePerson(this);
        }
    }
}
