package ru.zinoviev.DBEngine.utils;

import ru.zinoviev.DBEngine.ManagerUtil.EntityUtil;
import ru.zinoviev.DBEngine.dao.*;
import ru.zinoviev.DBEngine.dao.cardOptions.CardOptions;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class DAOUtils {



    private static String[] getStrings(){
        String[] UserData = new String[5];

        String[] MNames = {
                "Дмитрий","Михаил","Альберт","Сергей","Афонасий","Петр","Зиновий","Павел","Карл","Максим","Альфред",
                "Александр","Валерий","Вячеслав","Константин","Анатолий","Егор","Кащей","Иван","Добрыня","Никита"};
        String[] MPatr = {
                "Дмитриевич","Михаилович","Альбертович","Сергеевич","Афонасиевич","Петрович","Зиновьевич","Павелович","Карлович","Максимович","Альфредович",
                "Александрович","Валериевич","Вячеславович","Константинович","Анатолиевич","Егорович","Кащеевич","Иванович","Добрыневич","Никитович"};


        String[] FNames = {
                "Елена","Светлана","Роза","Людмила","Мария","Кристина","Фекла","Александра","Наталья","Татьяна","Соня",
                "Екатерина","Ангелина","Любава","Прокофья","Валерьяна","Сара","Джессика","Авдотья","Агафья","Роза"};
        String[] FPatr = {
                "Дмитриевна","Михаиловна","Альбертовна","Сергеевна","Афонасиевна","Петровна","Зиновьевна","Павеловна","Карловна","Максимовна","Альфредовна",
                "Александровна","Валериевна","Вячеславовна","Константиновна","Анатолиевна","Егоровна","Кащеевна","Ивановна","Добрыневна","Никитовна"};


        String[] AlastName = {
                "Зубило","Креведка","Пастернак","Травка","Пылесос","Чайник","Кофемолка","Залупкин","Владлен","Михайло","Гутлир",
                "Хэнкс","Двачу","Котик","Диван","Перелом","Приколюшка","Стрикс","Сырок","Сладость","Смазка"};


        String[] Sity = {
                "Екатеринбург ","Смоленск ","Нижний новогород ","Москва ","Петропавловск ","Алушта ","Сочи ","Челябинск ","Краснодар ","Рыбинск ","Калининград ",
                "Днепропетровск ","Кыштым ","Нью-Йорк ","Лос Анжелес ","Зигуевка ","Питер ","Владивосток ","Владимир ","Волгоград ","Знаменка "};

        String[] Street = {
                "Питербуржская ","Няшкина ","Советская ","Ленинская ","Рыбная ","переулок Парковый ","Восстания ","Синявкина ","Владленова ","Партугальская ","Ититская ",
                "Новикова ","Дачная ","Кошачья ","Кривая ","переулок Лысый ","Заостружная ","Нарильская ","Железная ","Сказочная ","Столовая "};

        Random r = new Random();

        switch (r.nextInt(2)+1){
            case 1: {
                UserData[0] = MNames[r.nextInt(MNames.length)];
                UserData[1] = MPatr[r.nextInt(MPatr.length)];
                UserData[2] = AlastName[r.nextInt(AlastName.length)];
                UserData[3] = "город "+Sity[r.nextInt(Sity.length)] +", улица "+Street[r.nextInt(Street.length)]+", "+(r.nextInt(200)+1)+", квартира "+(r.nextInt(350)+1);
                break;
            }

            case 2: {
                UserData[0] = FNames[r.nextInt(FNames.length)];
                UserData[1] = FPatr[r.nextInt(FPatr.length)];
                UserData[2] = AlastName[r.nextInt(AlastName.length)];
                UserData[3] = "город "+Sity[r.nextInt(Sity.length)] +", улица "+Street[r.nextInt(Street.length)]+", "+(r.nextInt(200)+1)+", квартира "+(r.nextInt(350)+1);
                break;
            }

            default: {
                break;
            }
        }

        return UserData;
    }



    public static void addFakeUsers(int cout, boolean addAlseItems) {

        String[] userData = new String[4];
        EntityManager entityManager = EntityUtil.getEntityManager();
        entityManager.getTransaction().begin();

        for (int i = 0; i < cout; i++) {

            userData = getStrings();

            BankCustomer customer = new BankCustomer();
            customer.setFirstName(userData[0]);
            customer.setPatronymic(userData[1]);
            customer.setLastName(userData[2]);
            customer.setAge(new Random().nextInt(80) + 10);
            customer.setAdress(userData[3]);
            customer.setRegistrationDate(new Date().getTime());

            int deposit = new Random().nextInt(2);
            if(deposit == 0){
                customer.setStatus(0);
            }else {
                customer.setStatus(1);
            }


            entityManager.persist(customer);


            if(addAlseItems){
                addItems(customer, entityManager);
            }
        }

        entityManager.getTransaction().commit();
        entityManager.clear();
    }


    private static void addItems(BankCustomer customer, EntityManager entityManager){

        // adding some credits
        for (int i = 0; i < new Random().nextInt(10); i++) {
            BankCredit credit =
                    entityManager.find(BankCredit.class, (long)(new Random().nextInt(4)+1));

            CreditCustomer creditCustomer = new CreditCustomer();
            creditCustomer.setValue((long) (new Random().nextInt((int) credit.getMaxValue())+10));
            creditCustomer.setTaken(new Date().getTime());
            creditCustomer.setCredit(credit);
            creditCustomer.setCustomer(customer);

            int deposit = new Random().nextInt(3);
            if(deposit == 0 | deposit == 1){
                creditCustomer.setRepaidValue(creditCustomer.getValue()- (long)(new Random().nextInt((int)creditCustomer.getValue()-100)));
                creditCustomer.setClosed(false);
            }
            if(deposit == 2){
                creditCustomer.setRepaidValue(creditCustomer.getValue());
                creditCustomer.setClosed(true);
            }

            entityManager.persist(creditCustomer);
        }


        //add some statements and cards
        for (int i = 0; i < new Random().nextInt(10)+1; i++) {
            BankStatement bankStatement = new BankStatement();
            bankStatement.setValue(BigDecimal.valueOf(new Random().nextDouble() * new Random().nextInt(100000) + 1000)
                    .setScale(3, RoundingMode.HALF_UP)
                    .doubleValue());
            bankStatement.setStatementNumber((new Random().nextLong()+1));
            entityManager.persist(bankStatement);

            CustomerStatementsCard customerStatements = new CustomerStatementsCard();
            int x = new Random().nextInt(2);
              switch (x) {
                case 0:{break;}
                case 1:{
                    BankCard card = entityManager.find(BankCard.class, ((long)new Random().nextInt(7)+1));
                    customerStatements.setCard(card);
                    customerStatements.setCardNumber((new Random().nextLong()+1));

                    if(card.getOptions().isMiles() == true){
                        customerStatements.setMilesCount(new Random().nextInt(10000));
                    } else {
                        customerStatements.setMilesCount(0);
                    }
                    break;}
                default: {break;}
              }


            int deposit = new Random().nextInt(2);
            if(deposit == 0){
                customerStatements.setDeposit(false);
            }else {
                customerStatements.setDeposit(true);
            }

            customerStatements.setRegistrationDate(new Date().getTime());
            customerStatements.setCustomer(customer);
            customerStatements.setStatement(bankStatement);


            entityManager.persist(customerStatements);
        }

      //  entityManager.getTransaction().commit();
    }


    public static void CreateCardsTable(){
        CardOptions cardOptions = new CardOptions();
        cardOptions.setMiles(false);
        cardOptions.setMilesIncrementValue(0);
        cardOptions.setCashBack(true);
        cardOptions.setCashBackValue(1.2);
        cardOptions.setFreeExchange(false);
        cardOptions.setFreetoUse(false);
        cardOptions.setFuelCashback(false);
        cardOptions.setFuelCashbackValue(0);
        DAOUtils.add(cardOptions);

        BankCard bankCard = new BankCard();
        bankCard.setCardName("Visa");
        bankCard.setInternationalCard(true);
        bankCard.setOptions(cardOptions);
        DAOUtils.add(bankCard);
//----------------------------------------
        cardOptions = new CardOptions();
        cardOptions.setMiles(false);
        cardOptions.setMilesIncrementValue(0);
        cardOptions.setCashBack(false);
        cardOptions.setCashBackValue(0);
        cardOptions.setFreeExchange(true);
        cardOptions.setFreetoUse(false);
        cardOptions.setFuelCashback(true);
        cardOptions.setFuelCashbackValue(10);
        DAOUtils.add(cardOptions);

        bankCard = new BankCard();
        bankCard.setCardName("Vip");
        bankCard.setInternationalCard(true);
        bankCard.setOptions(cardOptions);
        DAOUtils.add(bankCard);
        //----------------------------------------
        //----------------------------------------
        cardOptions = new CardOptions();
        cardOptions.setMiles(true);
        cardOptions.setMilesIncrementValue(1000);
        cardOptions.setCashBack(true);
        cardOptions.setCashBackValue(1.2);
        cardOptions.setFreeExchange(false);
        cardOptions.setFreetoUse(false);
        cardOptions.setFuelCashback(false);
        cardOptions.setFuelCashbackValue(0);
        DAOUtils.add(cardOptions);

        bankCard = new BankCard();
        bankCard.setCardName("Visa classic");
        bankCard.setInternationalCard(true);
        bankCard.setOptions(cardOptions);
        DAOUtils.add(bankCard);
//----------------------------------------
//----------------------------------------
        cardOptions = new CardOptions();
        cardOptions.setMiles(true);
        cardOptions.setMilesIncrementValue(1000);
        cardOptions.setCashBack(true);
        cardOptions.setCashBackValue(1.5);
        cardOptions.setFreeExchange(false);
        cardOptions.setFreetoUse(true);
        cardOptions.setFuelCashback(true);
        cardOptions.setFuelCashbackValue(2);
        DAOUtils.add(cardOptions);

        bankCard = new BankCard();
        bankCard.setCardName("Regular");
        bankCard.setInternationalCard(false);
        bankCard.setOptions(cardOptions);
        DAOUtils.add(bankCard);
//----------------------------------------

//----------------------------------------
        cardOptions = new CardOptions();
        cardOptions.setMiles(true);
        cardOptions.setMilesIncrementValue(500);
        cardOptions.setCashBack(true);
        cardOptions.setCashBackValue(2);
        cardOptions.setFreeExchange(false);
        cardOptions.setFreetoUse(false);
        cardOptions.setFuelCashback(false);
        cardOptions.setFuelCashbackValue(0);
        DAOUtils.add(cardOptions);

        bankCard = new BankCard();
        bankCard.setCardName("Students");
        bankCard.setInternationalCard(false);
        bankCard.setOptions(cardOptions);
        DAOUtils.add(bankCard);
//----------------------------------------

//----------------------------------------
        cardOptions = new CardOptions();
        cardOptions.setMiles(false);
        cardOptions.setMilesIncrementValue(0);
        cardOptions.setCashBack(false);
        cardOptions.setCashBackValue(0);
        cardOptions.setFreeExchange(true);
        cardOptions.setFreetoUse(false);
        cardOptions.setFuelCashback(true);
        cardOptions.setFuelCashbackValue(3);
        DAOUtils.add(cardOptions);

        bankCard = new BankCard();
        bankCard.setCardName("Mastercard");
        bankCard.setInternationalCard(true);
        bankCard.setOptions(cardOptions);
        DAOUtils.add(bankCard);
//----------------------------------------

//----------------------------------------
        cardOptions = new CardOptions();
        cardOptions.setMiles(true);
        cardOptions.setMilesIncrementValue(10);
        cardOptions.setCashBack(true);
        cardOptions.setCashBackValue(10);
        cardOptions.setFreeExchange(true);
        cardOptions.setFreetoUse(true);
        cardOptions.setFuelCashback(true);
        cardOptions.setFuelCashbackValue(10);
        DAOUtils.add(cardOptions);

        bankCard = new BankCard();
        bankCard.setCardName("GOD");
        bankCard.setInternationalCard(true);
        bankCard.setOptions(cardOptions);
        DAOUtils.add(bankCard);
//----------------------------------------

//----------------------------------------
        cardOptions = new CardOptions();
        cardOptions.setMiles(false);
        cardOptions.setMilesIncrementValue(0);
        cardOptions.setCashBack(false);
        cardOptions.setCashBackValue(0);
        cardOptions.setFreeExchange(false);
        cardOptions.setFreetoUse(false);
        cardOptions.setFuelCashback(false);
        cardOptions.setFuelCashbackValue(0);
        DAOUtils.add(cardOptions);

        bankCard = new BankCard();
        bankCard.setCardName("Slave card");
        bankCard.setInternationalCard(false);
        bankCard.setOptions(cardOptions);
        DAOUtils.add(bankCard);
//----------------------------------------
    }

    public static void createCreditTable(){
        BankCredit credit = new BankCredit();
        EntityManager entityManager = EntityUtil.getEntityManager();

        credit.setCreditName("Бытовой");
        credit.setDaysLong(365);
        credit.setMaxValue(100000);
        credit.setRate(12.5);


        entityManager.getTransaction().begin();
        entityManager.persist(credit);
        entityManager.getTransaction().commit();

        credit = new BankCredit();
        credit.setCreditName("VIP");
        credit.setDaysLong(730);
        credit.setMaxValue(50000000);
        credit.setRate(1.2);
        entityManager.getTransaction().begin();
        entityManager.persist(credit);
        entityManager.getTransaction().commit();


        credit = new BankCredit();
        credit.setCreditName("На прибретение жилья");
        credit.setDaysLong(1825);
        credit.setMaxValue(10000000);
        credit.setRate(11.5);
        entityManager.getTransaction().begin();
        entityManager.persist(credit);
        entityManager.getTransaction().commit();

        credit = new BankCredit();
        credit.setCreditName("Привет, лошара!");
        credit.setDaysLong(50);
        credit.setMaxValue(100000);
        credit.setRate(66.6);
        entityManager.getTransaction().begin();
        entityManager.persist(credit);
        entityManager.getTransaction().commit();

        credit = new BankCredit();
        credit.setCreditName("Автомобильный");
        credit.setDaysLong(365);
        credit.setMaxValue(2000000);
        credit.setRate(12.5);
        entityManager.getTransaction().begin();
        entityManager.persist(credit);
        entityManager.getTransaction().commit();

        entityManager.clear();
    }

    public static void add(BankUnit unit) {
        EntityManager entityManager = EntityUtil.getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(unit);

        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    public static void addCredit(long customerId, long creditId, double value) {
        EntityManager entityManager = EntityUtil.getEntityManager();
        entityManager.getTransaction().begin();

        BankCustomer customer = entityManager.find(BankCustomer.class, customerId);

        BankCredit credit = entityManager.find(BankCredit.class, creditId);

        CreditCustomer creditCustomer = new CreditCustomer();
        creditCustomer.setClosed(false);
        creditCustomer.setCredit(credit);
        creditCustomer.setTaken(new Date().getTime());
        creditCustomer.setRepaidValue(0);
        creditCustomer.setCustomer(customer);
        creditCustomer.setValue(value);
        entityManager.persist(creditCustomer);

        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    public static void addCard(long userId, long cardId) {
        EntityManager entityManager = EntityUtil.getEntityManager();
        entityManager.getTransaction().begin();

        BankCustomer customer = entityManager.find(BankCustomer.class, userId);

        BankCard card = entityManager.find(BankCard.class, cardId);

        BankStatement statement = new BankStatement();
        statement.setStatementNumber(new Random().nextLong());
        statement.getValue();
        entityManager.persist(statement);

        CustomerStatementsCard customerStatementsCard = new CustomerStatementsCard();
        customerStatementsCard.setMilesCount(0);
        customerStatementsCard.setCardNumber(new Random().nextLong());
        customerStatementsCard.setStatement(statement);
        customerStatementsCard.setCard(card);
        customerStatementsCard.setDeposit(true); //TODO
        customerStatementsCard.setCustomer(customer);
        customerStatementsCard.setRegistrationDate(new Date().getTime());
        entityManager.persist(customerStatementsCard);

        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    public static void update(BankUnit unit) {
        EntityManager entityManager = EntityUtil.getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.merge(unit);

        entityManager.getTransaction().commit();
        entityManager.clear();
    }


    public static void repaidCredit(CreditCustomer unit, double value) {
        EntityManager entityManager = EntityUtil.getEntityManager();
        entityManager.getTransaction().begin();

        unit.setRepaidValue(unit.getRepaidValue() + value);

        if(unit.getRepaidValue() >= unit.getValue()){
            unit.setClosed(true);
        }

        entityManager.merge(unit);

        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    public static Object get(BankUnit unit, long id){
        EntityManager entityManager = EntityUtil.getEntityManager();
        entityManager.getTransaction().begin();

        unit = entityManager.find(unit.getClass(), id);

        entityManager.getTransaction().commit();
       // entityManager.clear();
        return unit;
    }

    public static List<BankCustomer> getCustomerslist(int start, int max) {
        EntityManager entityManager = EntityUtil.getEntityManager();
        entityManager.getTransaction().begin();

        List<BankCustomer> customerModels = entityManager.createQuery("FROM BankCustomer")
                .setFirstResult(start)
                .setMaxResults(max)
                .getResultList();

        entityManager.getTransaction().commit();
    //    entityManager.clear();
        return customerModels;
    }

    public static List<BankCredit> getCreditlist() {
        EntityManager entityManager = EntityUtil.getEntityManager();
        entityManager.getTransaction().begin();

        List<BankCredit> bankCredits = entityManager.createQuery("FROM BankCredit")
                .getResultList();

        entityManager.getTransaction().commit();
        return bankCredits;
    }

    public static List<BankCard> getCardlist() {
        EntityManager entityManager = EntityUtil.getEntityManager();
        entityManager.getTransaction().begin();

        List<BankCard> cards = entityManager.createQuery("FROM BankCard")
                .getResultList();

        entityManager.getTransaction().commit();
        return cards;
    }

    public static BankUnit remove(BankUnit unit){
        EntityManager entityManager = EntityUtil.getEntityManager();
        entityManager.getTransaction().begin();

        if(unit instanceof BankCustomer){
            BankCustomer customer = (BankCustomer) unit;
            entityManager.remove(customer);
        }

        entityManager.getTransaction().commit();
        entityManager.clear();
        return unit;
    }

}
