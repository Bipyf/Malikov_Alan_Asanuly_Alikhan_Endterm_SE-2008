PGDMP     ;    7                y            jvpr    13.0    13.0     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    165688    jvpr    DATABASE     a   CREATE DATABASE jvpr WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';
    DROP DATABASE jvpr;
                postgres    false            ?            1259    173911    client    TABLE     E  CREATE TABLE public.client (
    client_id integer NOT NULL,
    client_phone character varying(255),
    client_login character varying(255),
    client_fname character varying(255),
    client_password character varying(255),
    toy_id integer,
    costume_id integer,
    client_sum bigint,
    product_amount integer
);
    DROP TABLE public.client;
       public         heap    postgres    false            ?            1259    173906    costume    TABLE     ?   CREATE TABLE public.costume (
    costume_id integer NOT NULL,
    costume_name character varying(255),
    costume_price integer,
    costume_amount integer
);
    DROP TABLE public.costume;
       public         heap    postgres    false            ?            1259    173898    toys    TABLE     ?   CREATE TABLE public.toys (
    toy_id integer NOT NULL,
    toy_name character varying(255),
    toy_price integer,
    toy_amount integer,
    toy_type character varying(255)
);
    DROP TABLE public.toys;
       public         heap    postgres    false            ?          0    173911    client 
   TABLE DATA           ?   COPY public.client (client_id, client_phone, client_login, client_fname, client_password, toy_id, costume_id, client_sum, product_amount) FROM stdin;
    public          postgres    false    202   ?       ?          0    173906    costume 
   TABLE DATA           Z   COPY public.costume (costume_id, costume_name, costume_price, costume_amount) FROM stdin;
    public          postgres    false    201          ?          0    173898    toys 
   TABLE DATA           Q   COPY public.toys (toy_id, toy_name, toy_price, toy_amount, toy_type) FROM stdin;
    public          postgres    false    200   ?       /           2606    173918    client client_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (client_id);
 <   ALTER TABLE ONLY public.client DROP CONSTRAINT client_pkey;
       public            postgres    false    202            -           2606    173910    costume costume_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.costume
    ADD CONSTRAINT costume_pkey PRIMARY KEY (costume_id);
 >   ALTER TABLE ONLY public.costume DROP CONSTRAINT costume_pkey;
       public            postgres    false    201            +           2606    173905    toys toys_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.toys
    ADD CONSTRAINT toys_pkey PRIMARY KEY (toy_id);
 8   ALTER TABLE ONLY public.toys DROP CONSTRAINT toys_pkey;
       public            postgres    false    200            1           2606    173924    client client_costume_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_costume_id_fkey FOREIGN KEY (costume_id) REFERENCES public.costume(costume_id);
 G   ALTER TABLE ONLY public.client DROP CONSTRAINT client_costume_id_fkey;
       public          postgres    false    2861    201    202            0           2606    173919    client client_toy_id_fkey    FK CONSTRAINT     z   ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_toy_id_fkey FOREIGN KEY (toy_id) REFERENCES public.toys(toy_id);
 C   ALTER TABLE ONLY public.client DROP CONSTRAINT client_toy_id_fkey;
       public          postgres    false    202    2859    200            ?      x?????? ? ?      ?   ?   x?]ϱ?0???S??B]?$D]J???ڄ?cI?n?/??.A5Ө??Dݼu$?V?1(i|?H?źA??2?dے?y?Q?Iσ??q'?u4?>ȂogT?'???{?1
ZI??]Rfc?o?h?e?wAƎ?H?s??U??~`?? WsG?      ?   c  x?e?Mn?0???SX=@?!@?mRUM[%Yvc?,?Њ??6???o?????C8??Y?zeg?  ?IKi??X=͑Wus?Sv?hIo??Xބ? o?7??JȂn?ns.?8ph?i-I?^?????jl!?rx??p?E?UR?{9??+?	%?Z????]b?Bk!???c??W??1?$?֯??u#?h????ZY?
??̰2-?????5??4?5,?U?????h?.????.?T	?y!4=qc??)?pԽ??®?R??D?h?????-O?KxGs??α;??I?lDQbK.M???x?S????$3?^tK*D??yBs?a?M.pD???????H??L?T     