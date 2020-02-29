create function findproducts(category_pattern character varying)
    returns TABLE(id integer, stock_far integer, stock_main integer,
    descr character varying, pricen numeric, partnumber character varying,
     category character varying)
    language plpgsql
as
$$
BEGIN
    if category_pattern is null
    then
        begin
            RETURN QUERY SELECT
                             t.id, t.stock_far, t.stock_main, t.descr, t.pricen, t,partnumber, t.category
                         FROM dealers.product as t;
        end;
    else
        begin
            RETURN QUERY SELECT
                             t.id, t.stock_far, t.stock_main, t.descr, t.pricen, t,partnumber, t.category
                         FROM dealers.product as t
                         where t.category = category_pattern;
        end;
    end if;
END;
$$;

alter function findproducts(varchar) owner to postgres;

