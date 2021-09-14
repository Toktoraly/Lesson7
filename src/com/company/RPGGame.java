package com.company;

import com.company.boss.Boss;
import com.company.players.*;

public class RPGGame {
    private static void printStatistics(Hero heroes[], Boss boss) {
        System.out.println("__________________________");
        System.out.println("Boss healt: " + boss.getHealth());
        for (Hero hero : heroes) {
            System.out.println("Hero " + hero.getClass().getSimpleName()
                    + " current health: " + hero.getHealth());
        }
        System.out.println("__________________________");
    }

    private static void heroesHits(Hero heroes[], Boss boss) {
        for (Hero hero : heroes) {
            int heroDamage = hero.getDamage();
            boss.putDamage(heroDamage);
            System.out.println("Hero" + hero.getClass().getSimpleName() + "atack Boss" + heroDamage);
        }
    }

    private static void bossHits(Hero heroes[], Boss boss) {
        for (Hero hero : heroes) {
            int bossDamage = boss.getDamage();
            hero.putDamage(bossDamage);
            System.out.println("Hero" + hero.getClass().getSimpleName() + "atack Boss" + bossDamage);
        }
    }

    private static boolean isFinish(Hero heroes[], Boss boss) {
        if (boss.getHealth() > 0) {
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            allHeroesDead = false;
            break;
        }

        return allHeroesDead;
    }
    private static void applyAbility(Hero heroes[], Boss boss){
        for (Hero hero: heroes){
            hero.useAbility(heroes, boss);
        }
    }
    public static void round(Hero heroes[], Boss boss){
        //Нанесение урона боссом
        bossHits(heroes,boss);
        if (isFinish(heroes, boss)) {
            printStatistics(heroes,boss);
        }
        //Нанесение урона героями
        heroesHits(heroes, boss);

        // Приминение суперсбособностей
        applyAbility(heroes,boss);

        // Показ статистики
        printStatistics(heroes,boss);
        }
    public static void startGame(){
        Hero heroes[] = createHeroes();
        Boss boss  =new Boss(400, 30);
        printStatistics(heroes,boss);
        while (!isFinish(heroes,boss)){
            round(heroes,boss);
        }

    }
    private static  Hero[] createHeroes(){
        Hero heroes[] = new Hero[4];
        heroes[0]= new Hunter(100, 10);
        heroes[1]= new Magical(100, 10);
        heroes[2]= new Medic(100, 10);
        heroes[3]= new Warrior(100, 10);
        return  heroes;
    }
}
