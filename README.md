# Drools

See
- [spring-boot-drools](https://springhow.com/spring-boot-drools/)
- [spring-boot-drools-demo](https://github.com/springhow/spring-boot-drools-demo)
- [drools-rule-engine](https://springhow.com/drools-rule-engine/)
- [drools-decision](https://www.javainuse.com/drools/drools_decision)
- [drools documentations decision tables](https://docs.jboss.org/drools/release/7.7.0.Final/drools-docs/html_single/#_decision_tables_in_spreadsheets)


## Database

```sql
create role rule_lees LOGIN NOSUPERUSER NOCREATEDB NOCREATEROLE INHERIT NOREPLICATION CONNECTION LIMIT -1 PASSWORD 'rule_lees';
create role create role rule_mut LOGIN NOSUPERUSER NOCREATEDB NOCREATEROLE INHERIT NOREPLICATION CONNECTION LIMIT -1 PASSWORD 'rule_mut';
create role rule_owner LOGIN NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION PASSWORD 'rule_owner';

create database "myrules" with owner rule_owner encoding 'UTF-8' tablespace= pg_default LC_COLLATE='en_US.UTF-8' LC_CTYPE='en_US.UTF-8' CONNECTION LIMIT=-1;

grant connect on database myrules to rule_mut;
alter default privileges  grant select, insert, update, delete, truncate on tables to rule_mut;
alter default privileges  grant usage on sequences to rule_mut;

grant connect on database myrules to rule_lees;
alter default privileges  grant select  on tables to rule_lees;
```

## Test
```shell
curl -X POST -H "Content-type: application/json" -d '{ "orderId": "123", "paymentType": "CARD", "totalPrice":12700 }' http://localhost:8080/discount | jq '.'
```
