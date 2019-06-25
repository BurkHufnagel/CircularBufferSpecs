# CircularBufferSpecs
Specifications for a Java-based Circular Buffer written using the Spock framework

A circular buffer (aka ring buffer) can be thought of as a fixed length array with the start and endbeing logically 
connected. For example, if the size of the buffer is five then writing to the sixth element 
(one past the end) would actually overwrite the zeroth element.

While this may sound a little confusing, it's quite useful - especially if you have a stream of data and want to get the last n items.

Simple write the data to circular buffer as it arrives, then read from the buffer whenever you decide to. If the number 
of items written to the buffer us less than the buffer's size then you will get back all the items written. If the number 
of items written were greater than the size of the buffer then it will only return the last n items.

Check the Wikipedia entry (https://en.wikipedia.org/wiki/Circular_buffer) for more details.