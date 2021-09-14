package com.company.players;

import com.company.AbilityType;
import com.company.boss.Boss;

public class Medic extends Hero{
        public Medic(int health, int damage) {
        super(health, damage, AbilityType.HEAL);

    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {

    }
}
