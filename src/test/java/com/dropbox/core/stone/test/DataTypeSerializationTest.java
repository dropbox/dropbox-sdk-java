package com.dropbox.core.stone.test;

import static com.google.common.truth.Truth.assertThat;

import java.io.IOException;

import org.testng.annotations.Test;

import java.util.Date;

public class DataTypeSerializationTest {

    @Test
    public void testPreClassInitializationDeserialization() throws Exception {
        // verify that we can deserialize JSON for a class that has not yet been initialized
        // (e.g. no instances or fields have been accessed for this class yet)
        String json = "{\"reason\":{\".tag\":\"bad_feels\",\"bad_feels\":\"meh\"},\"session_id\":\"2\"}";
        Uninitialized actual = Uninitialized.Serializer.INSTANCE.deserialize(json);
        assertThat(actual.getSessionId()).isEqualTo("2");
        assertThat(actual.getReason().tag()).isEqualTo(UninitializedReason.Tag.BAD_FEELS);
        assertThat(actual.getReason().getBadFeelsValue()).isEqualTo(BadFeel.MEH);
    }

    @Test
    public void testCatchAllDeserialization() throws Exception {
        String json = "{\".tag\":\"catch_all\",\"catch_all\":\"test_unknown_tag\"}";
        NestingUnion actual = NestingUnion.Serializer.INSTANCE.deserialize(json);
        assertThat(actual.tag()).isEqualTo(NestingUnion.Tag.CATCH_ALL);
        assertThat(actual.getCatchAllValue()).isEqualTo(CatchAllUnion.OTHER);

        json = "{\".tag\":\"catch_all\",\"catch_all\":{\".tag\":\"test_unknown_tag\",\"test\":true}}";
        actual = NestingUnion.Serializer.INSTANCE.deserialize(json);
        assertThat(actual.tag()).isEqualTo(NestingUnion.Tag.CATCH_ALL);
        assertThat(actual.getCatchAllValue()).isEqualTo(CatchAllUnion.OTHER);

        json = "\"test_unknown_tag\"";
        actual = NestingUnion.Serializer.INSTANCE.deserialize(json);
        assertThat(actual).isNotNull();
        assertThat(actual.tag()).isEqualTo(NestingUnion.Tag.OTHER);
    }

    @Test(expectedExceptions={IOException.class})
    public void testNoCatchAllDeserialization() throws Exception {
        String json = "\"fake_\"";
        // ThumbnailFormat union has no catch-all
        ChildUnion.Serializer.INSTANCE.deserialize(json);
    }

    @Test
    public void testOutOfOrderFields() throws Exception {
        String json = "{\"height\":768,\"width\":1024}";
        Dimensions expected = new Dimensions(1024, 768);
        Dimensions actual = Dimensions.Serializer.INSTANCE.deserialize(json);

        assertThat(actual).isEqualTo(expected);

        json = "{\"width\":1024,\"height\":768}";
        actual = Dimensions.Serializer.INSTANCE.deserialize(json);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testUnknownStructFields() throws Exception {
        String json = "{\"height\":768,\"alpha\":0.5,\"width\":1024,\"foo\":{\"bar\":[1, 2, 3],\"baz\":false}}";
        Dimensions expected = new Dimensions(1024, 768);
        Dimensions actual = Dimensions.Serializer.INSTANCE.deserialize(json);

        assertThat(actual).isEqualTo(expected);

        // sometimes the order can matter. Add an unknown struct field early to see if we skip it properly
        json = "{\"height\":768,\"foo\":{\"bar\":[1, 2, 3],\"baz\":false},\"alpha\":0.5,\"width\":1024}";
        expected = new Dimensions(1024, 768);
        actual = Dimensions.Serializer.INSTANCE.deserialize(json);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDateTimestamp() throws Exception {
        Date born = new Date(1452816000000L); // 2016-01-15
        Cat expected = Cat.newBuilder("Mimi")
            .withBorn(born)
            .build();

        String json = Cat.Serializer.INSTANCE.serialize(expected);
        Cat actual = Cat.Serializer.INSTANCE.deserialize(json);

        assertThat(actual).isEqualTo(expected);

        // explicitly use long date
        json = "{\".tag\":\"cat\",\"name\":\"Mimi\",\"born\":\"2016-01-15T00:00:00Z\"}";
        actual = Cat.Serializer.INSTANCE.deserialize(json);

        assertThat(actual).isEqualTo(expected);

        // use short date
        json = "{\".tag\":\"cat\",\"name\":\"Mimi\",\"born\":\"2016-01-15\"}";
        actual = Cat.Serializer.INSTANCE.deserialize(json);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testEnumeratedSubtypes() throws Exception {
        Dog dog = Dog.newBuilder("Fido", "German Shepard")
            .withBorn(new Date(1457477906315L))
            .withSize(DogSize.LARGE)
            .build();

        Cat cat = new Cat("Jingles");

        Fish fish = new Fish("Blep", "Goldfish", TankSize.medium(new Dimensions(80, 40)));

        Pet pet = new Pet("generic");

        String json = Dog.Serializer.INSTANCE.serialize(dog);
        Pet actual = Pet.Serializer.INSTANCE.deserialize(json);

        assertThat(actual.getClass()).isEqualTo(Dog.class);
        assertThat(actual).isEqualTo(dog);

        json = Cat.Serializer.INSTANCE.serialize(cat);
        actual = Pet.Serializer.INSTANCE.deserialize(json);

        assertThat(actual.getClass()).isEqualTo(Cat.class);
        assertThat(actual).isEqualTo(cat);

        json = Fish.Serializer.INSTANCE.serialize(fish);
        actual = Pet.Serializer.INSTANCE.deserialize(json);

        assertThat(actual.getClass()).isEqualTo(Fish.class);
        assertThat(actual).isEqualTo(fish);

        json = Pet.Serializer.INSTANCE.serialize(pet);
        actual = Pet.Serializer.INSTANCE.deserialize(json);

        assertThat(actual.getClass()).isEqualTo(Pet.class);
        assertThat(actual).isEqualTo(pet);

        // check that we can deserialize as the specific type if necessary.
        json = Dog.Serializer.INSTANCE.serialize(dog);
        actual = Dog.Serializer.INSTANCE.deserialize(json);

        assertThat(actual.getClass()).isEqualTo(Dog.class);
        assertThat(actual).isEqualTo(dog);
    }

    @Test
    public void testOptionalPrimitives() throws Exception {
        // make sure optional primitives are deserialized properly
        Cat expected = new Cat("Pusheen");

        String json = "{\".tag\":\"cat\",\"name\":\"Pusheen\"}";
        Cat actual = Cat.Serializer.INSTANCE.deserialize(json);

        assertThat(actual).isEqualTo(expected);

        // set the optional fields
        expected = Cat.newBuilder("Pusheen")
            .withBorn(new Date(123456789000L))
            .withBreed("British Shorthair")
            .withIndoor(false)
            .build();

        json = Cat.Serializer.INSTANCE.serialize(expected);
        actual = Cat.Serializer.INSTANCE.deserialize(json);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testUnionInheritanceSerialization() throws Exception {
        String actual = ChildUnion.Serializer.INSTANCE.serialize(ChildUnion.ALPHA);
        assertThat(actual).isEqualTo("\"alpha\"");
    }

    @Test
    public void testUnionInheritanceDeserialization() throws Exception {
        String json = "\"alpha\"";
        ChildUnion actual = ChildUnion.Serializer.INSTANCE.deserialize(json);
        assertThat(actual).isEqualTo(ChildUnion.ALPHA);
    }

}
