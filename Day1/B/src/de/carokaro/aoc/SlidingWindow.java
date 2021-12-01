package de.carokaro.aoc;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SlidingWindow <T> implements Iterable<T>
{
    private final Deque<T> deque;
    private final int windowSize;

    public SlidingWindow(int windowSize, Deque<T> deque)
    {
        this.windowSize = windowSize;
        this.deque = deque;
    }

    public Boolean isFull()
    {
        return deque.size() >= windowSize;
    }

    public void push(T element)
    {
        deque.push(element);
        if (deque.size() > windowSize)
        {
            deque.removeLast();
        }
    }

    @Override
    public Iterator<T> iterator()
    {
        return deque.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action)
    {
        deque.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator()
    {
        return deque.spliterator();
    }
}
