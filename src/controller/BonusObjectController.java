package controller;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import executer.Executer;
import view.MainFrame;
import model.Bar;
import model.Bonus;
import model.BonusObject;
import model.Bonus_ballSpeed;
import model.Bonus_life;
import model.Bonus_points;
import model.Bonus_size;
import model.Game;

public class BonusObjectController
{
	private Game game;
	private MainFrame mainFrame;
	private List<BonusObject> boList;
	private Class<?>[] bonusTypes = {Bonus_ballSpeed.class, Bonus_life.class, Bonus_points.class, Bonus_size.class};
	
	public BonusObjectController(Game game, MainFrame mainFrame) {
		this.game = game;
		this.mainFrame = mainFrame;
		boList = new ArrayList<BonusObject>();
		mainFrame.setBonusObjectsList(boList);
	}
	
	private boolean outsideWindow(BonusObject bo)
	{
		return bo.getY() - bo.getSize() > Executer.WIN_HEIGHT ||
				bo.getY() + bo.getSize() < 0 ||
				bo.getX() - bo.getSize() > Executer.WIN_WIDTH ||
				bo.getX() + bo.getSize() < 0;
	}
	
	private boolean barCatched(BonusObject bo)
	{
		Bar bar = mainFrame.getBar();
		return bar.isWithinBarRange(bo.getX() - bo.getSize(), bo.getX() + bo.getSize()) &&
				bo.getY() + bo.getSize() > bar.getTopY() &&
				bo.getY() - bo.getSize() < bar.getY() + bar.getHeight() / 2;
	}
	
	private void useBonus(int type)
	{
		Class<?> bonus = bonusTypes[type % bonusTypes.length];
		try
		{
			Constructor<?> ctor = bonus.getConstructor(Game.class);
			Bonus b = (Bonus) ctor.newInstance(new Object[] { game });
			game.registerBonus(b);
			b.launchBonus();
		}
		catch (Exception e)
		{
			// TODO Handle error
			// Possible exceptions : NoSuchMethodException, SecurityException, InstantiationException
			//   IllegalAccessException, IllegalArgumentException, InvocationTargetException
			e.printStackTrace();
		}
	}
	
	public void refresh()
	{
		synchronized (boList)
		{
			for (Iterator<BonusObject> iterator = boList.iterator(); iterator.hasNext();)
			{
				BonusObject bo = (BonusObject) iterator.next();
				bo.setX(bo.getX() + bo.getSpeed() * Math.cos(bo.getDir()));
				bo.setY(bo.getY() + bo.getSpeed() * Math.sin(bo.getDir()));
				if(outsideWindow(bo))
				{
					iterator.remove();
					continue;
				}
				if(barCatched(bo))
				{
					useBonus(bo.getType());
					iterator.remove();
					continue;
				}
			}
			//mainFrame.paintBonusObjects(boList);
			//mainFrame.repaint();
		}
	}
	

	public void createBonusObject(int type, double x, double y)
	{
		addBonusObject(new BonusObject(type, x, y));
	}
	
	public void addBonusObject(BonusObject bo)
	{
		synchronized (boList)
		{
			boList.add(bo);
		}
	}
	public void removeBonusObject(BonusObject bo)
	{
		synchronized (boList)
		{
			boList.remove(bo);
		}
	}
	public void clearBonusObjects()
	{
		synchronized (boList)
		{
			boList.clear();
		}
	}
}
