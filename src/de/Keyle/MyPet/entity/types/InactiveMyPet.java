/*
 * Copyright (C) 2011-2012 Keyle
 *
 * This file is part of MyPet
 *
 * MyPet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MyPet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MyPet. If not, see <http://www.gnu.org/licenses/>.
 */

package de.Keyle.MyPet.entity.types;

import de.Keyle.MyPet.skill.MyPetGenericSkill;
import de.Keyle.MyPet.util.MyPetPlayer;
import net.minecraft.server.NBTTagCompound;
import org.bukkit.Location;

import java.util.Collection;

public class InactiveMyPet
{
    private String Name = "Wolf";
    private final MyPetPlayer Owner;
    private int Health;
    private int RespawnTime;
    private boolean isSitting;
    private Location Location;
    private double Exp;
    private MyPetType Type = MyPetType.Wolf;

    private NBTTagCompound NBTSkills = new NBTTagCompound("Skills");
    private NBTTagCompound NBTextendetInfo;

    public InactiveMyPet(MyPetPlayer Owner)
    {
        this.Owner = Owner;
    }

    public void setSkills(Collection<MyPetGenericSkill> skills)
    {
        if (skills.size() > 0)
        {
            for (MyPetGenericSkill skill : skills)
            {
                NBTTagCompound s = skill.save();
                if (s != null)
                {
                    this.NBTSkills.set(skill.getName(), s);
                }
            }
        }
    }

    public void setSkills(NBTTagCompound Skills)
    {
        NBTSkills = Skills;
    }

    public void setInfo(NBTTagCompound info)
    {
        NBTextendetInfo = info;
    }

    public NBTTagCompound getInfo()
    {
        return NBTextendetInfo;
    }

    public NBTTagCompound getSkills()
    {
        return NBTSkills;
    }

    public void setType(MyPetType type)
    {
        Type = type;
    }

    public MyPetType getType()
    {
        return Type;
    }

    public void setHealth(int Health)
    {
        this.Health = Health;
    }

    public int getHealth()
    {
        return Health;
    }

    public void setExp(double Exp)
    {
        this.Exp = Exp;
    }

    public double getExp()
    {
        return Exp;
    }

    public void setName(String Name)
    {
        this.Name = Name;
    }

    public String getName()
    {
        return Name;
    }

    public void setRespawnTime(int RespawnTime)
    {
        this.RespawnTime = RespawnTime;
    }

    public int getRespawnTime()
    {
        return RespawnTime;
    }

    public Location getLocation()
    {
        return Location;
    }

    public void setLocation(Location Location)
    {
        this.Location = Location;
    }

    public boolean isSitting()
    {
        return isSitting;
    }

    public void setSitting(boolean isSitting)
    {
        this.isSitting = isSitting;
    }

    public MyPetPlayer getOwner()
    {
        return Owner;
    }

    @Override
    public String toString()
    {
        return "InactiveMyPet{type=" + getType().getTypeName() + ", owner=" + getOwner().getName() + ", name=" + Name + ", exp=" + getExp() + ", health=" + getHealth() + ", sitting=" + isSitting() + "}";
    }
}