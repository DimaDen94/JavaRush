package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 20.03.2016.
 */
public class FakeModel implements Model
{
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData()
    {
        return modelData;
    }

    @Override
    public void loadUsers()
    {
        List<User> list = new ArrayList<>();
        list.add(new User("name", 1, 2));
        modelData.setUsers(list);
    }

    @Override
    public void loadDeletedUsers()
    {
        throw new UnsupportedOperationException();
    }
}
