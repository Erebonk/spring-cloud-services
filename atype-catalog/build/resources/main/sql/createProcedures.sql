create or replace function dealers.findproducts(category_pattern varchar)
    returns TABLE(id integer, stock_far varchar, stock_main varchar,
                  descr character varying, pricen numeric, partnumber varchar,
                  category varchar)
    language plpgsql
as
$$
BEGIN
    if category_pattern is null
    then
        begin
            RETURN QUERY SELECT
                             t.id, t.stock_far, t.stock_main, t.descr, t.pricen, t.partnumber, t.category
                         FROM dealers.product as t;
        end;
    else
        begin
            RETURN QUERY SELECT
                             t.id, t.stock_far, t.stock_main, t.descr, t.pricen, t.partnumber, t.category
                         FROM dealers.product as t
                         where t.category = category_pattern;
        end;
    end if;
END;
$$;

alter function dealers.findproducts(varchar) owner to postgres;

