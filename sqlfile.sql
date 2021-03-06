PGDMP     3                    x            cinema    13.1    13.1 K    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16394    cinema    DATABASE     f   CREATE DATABASE cinema WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE cinema;
                postgres    false            �            1259    24638    assento    TABLE     q   CREATE TABLE public.assento (
    id integer NOT NULL,
    sala integer NOT NULL,
    numero integer NOT NULL
);
    DROP TABLE public.assento;
       public         heap    postgres    false            �           0    0    TABLE assento    ACL     -   GRANT ALL ON TABLE public.assento TO "user";
          public          postgres    false    209            �            1259    24636    assento_id_seq    SEQUENCE     �   CREATE SEQUENCE public.assento_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.assento_id_seq;
       public          postgres    false    209            �           0    0    assento_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.assento_id_seq OWNED BY public.assento.id;
          public          postgres    false    208                        0    0    SEQUENCE assento_id_seq    ACL     7   GRANT ALL ON SEQUENCE public.assento_id_seq TO "user";
          public          postgres    false    208            �            1259    16446    caixa    TABLE     P   CREATE TABLE public.caixa (
    id integer NOT NULL,
    funcionario integer
);
    DROP TABLE public.caixa;
       public         heap    postgres    false                       0    0    TABLE caixa    ACL     +   GRANT ALL ON TABLE public.caixa TO "user";
          public          postgres    false    203            �            1259    16444    caixa_id_seq    SEQUENCE     �   CREATE SEQUENCE public.caixa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.caixa_id_seq;
       public          postgres    false    203                       0    0    caixa_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.caixa_id_seq OWNED BY public.caixa.id;
          public          postgres    false    202                       0    0    SEQUENCE caixa_id_seq    ACL     5   GRANT ALL ON SEQUENCE public.caixa_id_seq TO "user";
          public          postgres    false    202            �            1259    24597    filme    TABLE     �   CREATE TABLE public.filme (
    id integer NOT NULL,
    nome text NOT NULL,
    duracao integer NOT NULL,
    filme3d boolean NOT NULL
);
    DROP TABLE public.filme;
       public         heap    postgres    false                       0    0    TABLE filme    ACL     +   GRANT ALL ON TABLE public.filme TO "user";
          public          postgres    false    205            �            1259    24595    filme_id_seq    SEQUENCE     �   CREATE SEQUENCE public.filme_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.filme_id_seq;
       public          postgres    false    205                       0    0    filme_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.filme_id_seq OWNED BY public.filme.id;
          public          postgres    false    204                       0    0    SEQUENCE filme_id_seq    ACL     5   GRANT ALL ON SEQUENCE public.filme_id_seq TO "user";
          public          postgres    false    204            �            1259    16435    funcionario    TABLE     �   CREATE TABLE public.funcionario (
    id integer NOT NULL,
    nome text NOT NULL,
    cpf text NOT NULL,
    endereco text NOT NULL,
    telefone text NOT NULL
);
    DROP TABLE public.funcionario;
       public         heap    postgres    false                       0    0    TABLE funcionario    ACL     1   GRANT ALL ON TABLE public.funcionario TO "user";
          public          postgres    false    201            �            1259    16433    funcionario_id_seq    SEQUENCE     �   CREATE SEQUENCE public.funcionario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.funcionario_id_seq;
       public          postgres    false    201                       0    0    funcionario_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.funcionario_id_seq OWNED BY public.funcionario.id;
          public          postgres    false    200            	           0    0    SEQUENCE funcionario_id_seq    ACL     ;   GRANT ALL ON SEQUENCE public.funcionario_id_seq TO "user";
          public          postgres    false    200            �            1259    24693    ingresso    TABLE     �   CREATE TABLE public.ingresso (
    id integer NOT NULL,
    valor numeric(5,2) NOT NULL,
    meia boolean NOT NULL,
    sessao integer NOT NULL,
    assento integer NOT NULL
);
    DROP TABLE public.ingresso;
       public         heap    postgres    false            
           0    0    TABLE ingresso    ACL     .   GRANT ALL ON TABLE public.ingresso TO "user";
          public          postgres    false    213            �            1259    24691    ingresso_id_seq    SEQUENCE     �   CREATE SEQUENCE public.ingresso_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.ingresso_id_seq;
       public          postgres    false    213                       0    0    ingresso_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.ingresso_id_seq OWNED BY public.ingresso.id;
          public          postgres    false    212                       0    0    SEQUENCE ingresso_id_seq    ACL     8   GRANT ALL ON SEQUENCE public.ingresso_id_seq TO "user";
          public          postgres    false    212            �            1259    24608    sala    TABLE     N   CREATE TABLE public.sala (
    id integer NOT NULL,
    nome text NOT NULL
);
    DROP TABLE public.sala;
       public         heap    postgres    false                       0    0 
   TABLE sala    ACL     *   GRANT ALL ON TABLE public.sala TO "user";
          public          postgres    false    207            �            1259    24606    sala_id_seq    SEQUENCE     �   CREATE SEQUENCE public.sala_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.sala_id_seq;
       public          postgres    false    207                       0    0    sala_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.sala_id_seq OWNED BY public.sala.id;
          public          postgres    false    206                       0    0    SEQUENCE sala_id_seq    ACL     4   GRANT ALL ON SEQUENCE public.sala_id_seq TO "user";
          public          postgres    false    206            �            1259    24651    sessao    TABLE     �   CREATE TABLE public.sessao (
    id integer NOT NULL,
    filme integer NOT NULL,
    sala integer NOT NULL,
    data_hora timestamp without time zone NOT NULL
);
    DROP TABLE public.sessao;
       public         heap    postgres    false                       0    0    TABLE sessao    ACL     ,   GRANT ALL ON TABLE public.sessao TO "user";
          public          postgres    false    211            �            1259    24649    sessao_id_seq    SEQUENCE     �   CREATE SEQUENCE public.sessao_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.sessao_id_seq;
       public          postgres    false    211                       0    0    sessao_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.sessao_id_seq OWNED BY public.sessao.id;
          public          postgres    false    210                       0    0    SEQUENCE sessao_id_seq    ACL     6   GRANT ALL ON SEQUENCE public.sessao_id_seq TO "user";
          public          postgres    false    210            M           2604    24641 
   assento id    DEFAULT     h   ALTER TABLE ONLY public.assento ALTER COLUMN id SET DEFAULT nextval('public.assento_id_seq'::regclass);
 9   ALTER TABLE public.assento ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    208    209    209            J           2604    16449    caixa id    DEFAULT     d   ALTER TABLE ONLY public.caixa ALTER COLUMN id SET DEFAULT nextval('public.caixa_id_seq'::regclass);
 7   ALTER TABLE public.caixa ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202    203            K           2604    24600    filme id    DEFAULT     d   ALTER TABLE ONLY public.filme ALTER COLUMN id SET DEFAULT nextval('public.filme_id_seq'::regclass);
 7   ALTER TABLE public.filme ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    204    205            I           2604    16438    funcionario id    DEFAULT     p   ALTER TABLE ONLY public.funcionario ALTER COLUMN id SET DEFAULT nextval('public.funcionario_id_seq'::regclass);
 =   ALTER TABLE public.funcionario ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    200    201    201            O           2604    24696    ingresso id    DEFAULT     j   ALTER TABLE ONLY public.ingresso ALTER COLUMN id SET DEFAULT nextval('public.ingresso_id_seq'::regclass);
 :   ALTER TABLE public.ingresso ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    213    212    213            L           2604    24611    sala id    DEFAULT     b   ALTER TABLE ONLY public.sala ALTER COLUMN id SET DEFAULT nextval('public.sala_id_seq'::regclass);
 6   ALTER TABLE public.sala ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    206    207    207            N           2604    24654 	   sessao id    DEFAULT     f   ALTER TABLE ONLY public.sessao ALTER COLUMN id SET DEFAULT nextval('public.sessao_id_seq'::regclass);
 8   ALTER TABLE public.sessao ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    210    211    211            �          0    24638    assento 
   TABLE DATA           3   COPY public.assento (id, sala, numero) FROM stdin;
    public          postgres    false    209   �J       �          0    16446    caixa 
   TABLE DATA           0   COPY public.caixa (id, funcionario) FROM stdin;
    public          postgres    false    203   K       �          0    24597    filme 
   TABLE DATA           ;   COPY public.filme (id, nome, duracao, filme3d) FROM stdin;
    public          postgres    false    205   3K       �          0    16435    funcionario 
   TABLE DATA           H   COPY public.funcionario (id, nome, cpf, endereco, telefone) FROM stdin;
    public          postgres    false    201   PK       �          0    24693    ingresso 
   TABLE DATA           D   COPY public.ingresso (id, valor, meia, sessao, assento) FROM stdin;
    public          postgres    false    213   mK       �          0    24608    sala 
   TABLE DATA           (   COPY public.sala (id, nome) FROM stdin;
    public          postgres    false    207   �K       �          0    24651    sessao 
   TABLE DATA           <   COPY public.sessao (id, filme, sala, data_hora) FROM stdin;
    public          postgres    false    211   �K                  0    0    assento_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.assento_id_seq', 1, true);
          public          postgres    false    208                       0    0    caixa_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.caixa_id_seq', 1, true);
          public          postgres    false    202                       0    0    filme_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.filme_id_seq', 1, true);
          public          postgres    false    204                       0    0    funcionario_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.funcionario_id_seq', 1, true);
          public          postgres    false    200                       0    0    ingresso_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.ingresso_id_seq', 1, true);
          public          postgres    false    212                       0    0    sala_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.sala_id_seq', 1, true);
          public          postgres    false    206                       0    0    sessao_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.sessao_id_seq', 1, true);
          public          postgres    false    210            [           2606    24643    assento ChaveAssento 
   CONSTRAINT     T   ALTER TABLE ONLY public.assento
    ADD CONSTRAINT "ChaveAssento" PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.assento DROP CONSTRAINT "ChaveAssento";
       public            postgres    false    209            W           2606    24605    filme ChaveFilme 
   CONSTRAINT     P   ALTER TABLE ONLY public.filme
    ADD CONSTRAINT "ChaveFilme" PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.filme DROP CONSTRAINT "ChaveFilme";
       public            postgres    false    205            _           2606    24698    ingresso ChaveIngresso 
   CONSTRAINT     V   ALTER TABLE ONLY public.ingresso
    ADD CONSTRAINT "ChaveIngresso" PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.ingresso DROP CONSTRAINT "ChaveIngresso";
       public            postgres    false    213            Y           2606    24613    sala ChaveSala 
   CONSTRAINT     N   ALTER TABLE ONLY public.sala
    ADD CONSTRAINT "ChaveSala" PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.sala DROP CONSTRAINT "ChaveSala";
       public            postgres    false    207            ]           2606    24656    sessao ChaveSessao 
   CONSTRAINT     R   ALTER TABLE ONLY public.sessao
    ADD CONSTRAINT "ChaveSessao" PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.sessao DROP CONSTRAINT "ChaveSessao";
       public            postgres    false    211            a           2606    24710    ingresso UnicoAssento 
   CONSTRAINT     U   ALTER TABLE ONLY public.ingresso
    ADD CONSTRAINT "UnicoAssento" UNIQUE (assento);
 A   ALTER TABLE ONLY public.ingresso DROP CONSTRAINT "UnicoAssento";
       public            postgres    false    213            S           2606    24712    caixa UnicoFuncionario 
   CONSTRAINT     Z   ALTER TABLE ONLY public.caixa
    ADD CONSTRAINT "UnicoFuncionario" UNIQUE (funcionario);
 B   ALTER TABLE ONLY public.caixa DROP CONSTRAINT "UnicoFuncionario";
       public            postgres    false    203            U           2606    16451    caixa caixa_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.caixa
    ADD CONSTRAINT caixa_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.caixa DROP CONSTRAINT caixa_pkey;
       public            postgres    false    203            Q           2606    16443    funcionario funcionario_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT funcionario_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.funcionario DROP CONSTRAINT funcionario_pkey;
       public            postgres    false    201            g           2606    24704     ingresso ChaveEstrangeiraAssento    FK CONSTRAINT     �   ALTER TABLE ONLY public.ingresso
    ADD CONSTRAINT "ChaveEstrangeiraAssento" FOREIGN KEY (assento) REFERENCES public.assento(id);
 L   ALTER TABLE ONLY public.ingresso DROP CONSTRAINT "ChaveEstrangeiraAssento";
       public          postgres    false    209    2907    213            d           2606    24657    sessao ChaveEstrangeiraFilme    FK CONSTRAINT     {   ALTER TABLE ONLY public.sessao
    ADD CONSTRAINT "ChaveEstrangeiraFilme" FOREIGN KEY (filme) REFERENCES public.filme(id);
 H   ALTER TABLE ONLY public.sessao DROP CONSTRAINT "ChaveEstrangeiraFilme";
       public          postgres    false    205    2903    211            c           2606    24644    assento ChaveEstrangeiraSala    FK CONSTRAINT     y   ALTER TABLE ONLY public.assento
    ADD CONSTRAINT "ChaveEstrangeiraSala" FOREIGN KEY (sala) REFERENCES public.sala(id);
 H   ALTER TABLE ONLY public.assento DROP CONSTRAINT "ChaveEstrangeiraSala";
       public          postgres    false    2905    209    207            e           2606    24662    sessao ChaveEstrangeiraSala    FK CONSTRAINT     x   ALTER TABLE ONLY public.sessao
    ADD CONSTRAINT "ChaveEstrangeiraSala" FOREIGN KEY (sala) REFERENCES public.sala(id);
 G   ALTER TABLE ONLY public.sessao DROP CONSTRAINT "ChaveEstrangeiraSala";
       public          postgres    false    2905    207    211            f           2606    24699    ingresso ChaveEstrangeiraSessao    FK CONSTRAINT     �   ALTER TABLE ONLY public.ingresso
    ADD CONSTRAINT "ChaveEstrangeiraSessao" FOREIGN KEY (sessao) REFERENCES public.sessao(id);
 K   ALTER TABLE ONLY public.ingresso DROP CONSTRAINT "ChaveEstrangeiraSessao";
       public          postgres    false    213    2909    211            b           2606    16452    caixa caixa_funcionario_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.caixa
    ADD CONSTRAINT caixa_funcionario_fkey FOREIGN KEY (funcionario) REFERENCES public.funcionario(id);
 F   ALTER TABLE ONLY public.caixa DROP CONSTRAINT caixa_funcionario_fkey;
       public          postgres    false    203    201    2897            �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �     