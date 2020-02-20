create procedure dealers.findAllPriceTypes()
LANGUAGE plpgsql
as $$
begin
    select * from dealers.category;
end
$$;