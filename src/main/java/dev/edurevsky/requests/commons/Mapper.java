package dev.edurevsky.requests.commons;

public interface Mapper<In, Out> {

    Out map(In data);
}
