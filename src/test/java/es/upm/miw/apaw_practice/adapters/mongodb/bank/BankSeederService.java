package es.upm.miw.apaw_practice.adapters.mongodb.bank;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.BankAccountRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.BankRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.BankTypeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.ClientBankRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankAccountEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankTypeEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.ClientBankEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BankSeederService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private BankTypeRepository bankTypeRepository;
    @Autowired
    private ClientBankRepository clientBankRepository;


    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Bank Initial Load -----------");

        BankTypeEntity[] bankTypes = {
                new BankTypeEntity("Banco Comercial", "Banco que ofrece una amplia gama de servicios financieros a empresas y consumidores.", new BigDecimal("19000000.00")),

                new BankTypeEntity("Banco de Inversión", "Banco que se especializa en servicios de inversión y asesoramiento financiero.", new BigDecimal("10000000.00")),

                new BankTypeEntity("Banco Cooperativo", "Banco que es propiedad de sus miembros y opera con principios cooperativos.", new BigDecimal("30000000.00")),

                new BankTypeEntity("Banco de Desarrollo", "Banco público o privado que se enfoca en financiar proyectos de desarrollo y crecimiento económico en una región o país.", new BigDecimal("20000000.00"))

        };
        this.bankTypeRepository.saveAll(Arrays.asList(bankTypes));

        BankAccountEntity[] bankAccounts = {
                new BankAccountEntity("1234-5678-9012-3456", LocalDate.of(2025, 12, 31), 123, new BigDecimal("1000.00")),
                new BankAccountEntity("9876-5432-1098-7654", LocalDate.of(2024, 10, 15), 456, new BigDecimal("5000.00")),
                new BankAccountEntity("5678-1234-7890-2345", LocalDate.of(2023, 11, 30), 789, new BigDecimal("250.50")),
                new BankAccountEntity("4321-8765-4321-9876", LocalDate.of(2026, 8, 7), 234, new BigDecimal("12000.00")),
                new BankAccountEntity("8765-4321-9876-5432", LocalDate.of(2024, 5, 22), 567, new BigDecimal("750.75")),
                new BankAccountEntity("3456-7890-1234-5678", LocalDate.of(2025, 9, 5), 890, new BigDecimal("300.25")),
                new BankAccountEntity("1111-2222-3333-4444", LocalDate.of(2026, 6, 30), 111, new BigDecimal("7500.00")),
                new BankAccountEntity("5555-6666-7777-8888", LocalDate.of(2024, 12, 15), 777, new BigDecimal("15000.00")),
                new BankAccountEntity("9999-0000-1111-2222", LocalDate.of(2027, 4, 20), 999, new BigDecimal("200.00")),
                new BankAccountEntity("6543-2109-8765-4321", LocalDate.of(2025, 7, 18), 654, new BigDecimal("12000.00")),
                new BankAccountEntity("3210-9876-5432-1098", LocalDate.of(2023, 8, 27), 321, new BigDecimal("300.00")),
                new BankAccountEntity("7890-2345-6789-1234", LocalDate.of(2026, 3, 12), 789, new BigDecimal("6000.50")),
                new BankAccountEntity("1357-8642-9081-2468", LocalDate.of(2024, 11, 9), 135, new BigDecimal("875.25"))
        };

        this.bankAccountRepository.saveAll(Arrays.asList(bankAccounts));

        ClientBankEntity[] clientsBank = {
                new ClientBankEntity("Juan", "12345678A", "Pérez", 30, new ArrayList<>(Arrays.asList(bankAccounts[0], bankAccounts[1]))),
                new ClientBankEntity("Ana", "87654321B", "García", 28, new ArrayList<>(Arrays.asList(bankAccounts[2], bankAccounts[3]))),
                new ClientBankEntity("Carlos", "98765432C", "López", 35, new ArrayList<>(Arrays.asList(bankAccounts[4]))),
                new ClientBankEntity("María", "23456789D", "Martínez", 42, new ArrayList<>(Arrays.asList(bankAccounts[5], bankAccounts[10]))),
                new ClientBankEntity("Luis", "34567890E", "Hernández", 29, new ArrayList<>(Arrays.asList(bankAccounts[6], bankAccounts[11]))),
                new ClientBankEntity("Elena", "45678901F", "Sánchez", 33, new ArrayList<>(Arrays.asList(bankAccounts[7], bankAccounts[12]))),
                new ClientBankEntity("Sergio", "56789012G", "Gómez", 31, new ArrayList<>(Arrays.asList(bankAccounts[8]))),
                new ClientBankEntity("Laura", "67890123H", "Pérez", 27, new ArrayList<>(Arrays.asList(bankAccounts[9])))
        };
        this.clientBankRepository.saveAll(Arrays.asList(clientsBank));

        BankEntity srDellBank = new BankEntity("SrDell", "Madrid", new BigDecimal("90000000.00"), bankTypes[1]);
        List<BankAccountEntity> accountListbankSrDell = new ArrayList<>(Arrays.asList(bankAccounts[0], bankAccounts[1], bankAccounts[2], bankAccounts[3], bankAccounts[4], bankAccounts[5], bankAccounts[6]));
        srDellBank.setBankAccountEntityList(accountListbankSrDell);

        BankEntity bankPavon = new BankEntity("Bank Pavon", "Barcelona", new BigDecimal("12000000.00"), bankTypes[0]);
        List<BankAccountEntity> accountListbankPavon = new ArrayList<>(Arrays.asList(bankAccounts[7],bankAccounts[8],bankAccounts[9]));
        bankPavon.setBankAccountEntityList(accountListbankPavon);

        BankEntity dreamBank=new BankEntity("DreamBank", "Vigo", new BigDecimal("6500000.00"), bankTypes[0]);
        List<BankAccountEntity> accountListbankDream=new ArrayList<>(Arrays.asList(bankAccounts[10],bankAccounts[11],bankAccounts[12]));
        dreamBank.setBankAccountEntityList(accountListbankDream);

        BankEntity[] banks = {
                srDellBank,

                bankPavon,

                dreamBank

        };
        this.bankRepository.saveAll(Arrays.asList(banks));
    }

    public void deleteAll(){
        this.bankRepository.deleteAll();
        this.bankTypeRepository.deleteAll();
        this.clientBankRepository.deleteAll();
        this.bankAccountRepository.deleteAll();
    }
}
