package com.deliverbettersoftwarefaster.tdd.circularbuffer


import spock.lang.Specification


class CircularBufferSpecs extends Specification {

    def "CircularBuffer capapcity cannot be zero"() {
        when: "trying to create a CircularBuffer with a capacity of zero"
        def buffer = new CircularBuffer(0)

        then: "it should throw an IllegalArgumentException"
        thrown(IllegalArgumentException.class)
    }


    def "CircularBuffer capapcity cannot be less than zero"() {
        when: "trying to create a CircularBuffer with a capacity less than zero"
        def buffer = new CircularBuffer(-1)

        then: "it should throw an IllegalArgumentException"
        thrown(IllegalArgumentException.class)
    }


    def "a new CircularBuffer should be empty"() {
        given: "a new CircularBuffer that can hold eight Strings"
        def buffer = new CircularBuffer(8)

        when: "requesting how many items are currently in the buffer"
        def stored = buffer.stored()

        then: "it should report zero"
        stored == 0
    }


    def "when an item is added to a new CicrularBuffer it should have one item in it"() {
        given: "a new CircularBuffer that can hold eight Strings"
        def buffer = new CircularBuffer(8)

        when: "an item is added"
        buffer.add("To bodly go")

        then: "it should have room for seven more"
        def stored = buffer.stored()
        stored == 1
    }


    def "when an item is added to an empty CicrularBuffer and then removed it should match the original item"() {
        given: "a new CircularBuffer that can hold eight Strings"
        def buffer = new CircularBuffer(8)

        and: "an item is added"
        def item = "To bodly go"
        buffer.add(item)

        when: "an item is removed"
        def removedItem = buffer.remove();

        then: "it should match the original item"
        item == removedItem
    }


    def "when seven items are added to a CicrularBuffer that holds five items then it should contain the last five items added"() {
        given: "a new CircularBuffer that can hold five Strings"
        def buffer = new CircularBuffer(5)

        and: "and seven items are added"
        buffer.add("one")
        buffer.add("two")
        buffer.add("three")
        buffer.add("four")
        buffer.add("five")
        buffer.add("six")
        buffer.add("seven")

        when: "all the items are removed"
        def removedItem1 = buffer.remove()
        def removedItem2 = buffer.remove()
        def removedItem3 = buffer.remove()
        def removedItem4 = buffer.remove()
        def removedItem5 = buffer.remove()

        then: "the buffer shoud be empty"
        def stored = buffer.stored()
        stored == 0

        and: "the items removed should be the last five added, in the order they were added"
        removedItem1 == "three"
        removedItem2 == "four"
        removedItem3 == "five"
        removedItem4 == "six"
        removedItem5 == "seven"
    }
}