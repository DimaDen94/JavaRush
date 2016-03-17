package com.javarush.test.level34.lesson15.big01.model;

/**
 * Created by Dmitry on 17.03.2016.
 */
public abstract class CollisionObject extends GameObject
{

    public CollisionObject(int x, int y)
    {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction)
    {
        if (direction == Direction.UP && getY() == gameObject.getY() + Model.FIELD_SELL_SIZE && getX() == gameObject.getX())
        {
            return true;

        } else if (direction == Direction.DOWN && getY() == gameObject.getY() - Model.FIELD_SELL_SIZE  && getX() == gameObject.getX())
        {
            return true;
        } else if (direction == Direction.LEFT && getX() == gameObject.getX() + Model.FIELD_SELL_SIZE  && getY() == gameObject.getY())
        {
            return true;
        } else if (direction == Direction.RIGHT && getX() == gameObject.getX() - Model.FIELD_SELL_SIZE && getY() == gameObject.getY())
        {
            return true;
        } else return false;

    }
}
