package com.solvd.dao;

import com.solvd.models.Owner;

import java.util.List;


public interface IOwner {

    Owner getOwnerById(Long id);

    List<Owner> getOwner();
//
//    void insertOwner(Owner entity);
//
//    void deleteOwner(Integer entity);
//
//    void updateOwner(Owner entity);
}
