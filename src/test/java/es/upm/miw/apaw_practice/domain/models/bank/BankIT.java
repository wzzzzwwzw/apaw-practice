package es.upm.miw.apaw_practice.domain.models.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class BankIT {
    private BankComposite bankComposite;
    private Bank bank1,bank2,bank3;

    @BeforeEach
    void create(){
        this.bankComposite=new BankComposite("Composition");
        this.bank1=new Bank("BBVA","Madrid",new BigDecimal("22000000"),new BankType("General","Banco de caracter general",new BigDecimal("100000")));
        this.bank2=new Bank("Santander","Barcelona",new BigDecimal("10000000"),new BankType("Especifico","Banco de caracter especifico",new BigDecimal("100000")));
        this.bank3=new Bank("Bankia","Sevilla",new BigDecimal("50000000"),new BankType("Especifico","Banco de caracter especifico",new BigDecimal("100000")));
        this.bankComposite.add(bank1);
        this.bankComposite.add(bank2);
    }

    @Test
    void testLeafsAndComposite(){
        assertFalse(this.bank1.isComposite());
        assertFalse(this.bank2.isComposite());
        assertFalse(this.bank3.isComposite());
        assertTrue(this.bankComposite.isComposite());
    }

    @Test
    void testAddLeaf(){
        assertEquals(2,this.bankComposite.getTreeBanks().size());
        assertTrue(this.bankComposite.getTreeBanks().contains(this.bank1));
        assertTrue(this.bankComposite.getTreeBanks().contains(this.bank2));
        assertFalse(this.bankComposite.getTreeBanks().contains(bank3));
        this.bankComposite.add(this.bank3);
        assertEquals(3,this.bankComposite.getTreeBanks().size());
        assertTrue(this.bankComposite.getTreeBanks().contains(this.bank1));
        assertTrue(this.bankComposite.getTreeBanks().contains(this.bank2));
        assertTrue(this.bankComposite.getTreeBanks().contains(this.bank3));
    }

    @Test
    void testDeleteLeaf(){
        assertEquals(2,this.bankComposite.getTreeBanks().size());
        assertTrue(this.bankComposite.getTreeBanks().contains(this.bank1));
        assertTrue(this.bankComposite.getTreeBanks().contains(this.bank2));
        this.bankComposite.delete(this.bank2);
        assertEquals(1,this.bankComposite.getTreeBanks().size());
        assertTrue(this.bankComposite.getTreeBanks().contains(this.bank1));
        assertFalse(this.bankComposite.getTreeBanks().contains(this.bank2));
    }
    @Test
    void testLeafAdd(){
        assertThrows(UnsupportedOperationException.class, () ->this.bank1.add(this.bank3) );
    }

}
