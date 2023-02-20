package com.nisum.api.mapper;

public interface IMapper <I, O>{
    public O map(I in);
}
