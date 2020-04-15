--
-- PostgreSQL database dump
--

-- Dumped from database version 11.7 (Ubuntu 11.7-2.pgdg18.04+1)
-- Dumped by pg_dump version 11.7 (Ubuntu 11.7-2.pgdg18.04+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: order_products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.order_products (
    product_id integer NOT NULL,
    order_id integer NOT NULL,
    quanatity integer,
    price integer
);


ALTER TABLE public.order_products OWNER TO postgres;

--
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders (
    order_id bigint NOT NULL,
    date date,
    amount integer,
    user_id integer
);


ALTER TABLE public.orders OWNER TO postgres;

--
-- Name: orders_order_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orders_order_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orders_order_id_seq OWNER TO postgres;

--
-- Name: orders_order_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orders_order_id_seq OWNED BY public.orders.order_id;


--
-- Name: products_product_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.products_product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.products_product_id_seq OWNER TO postgres;

--
-- Name: products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products (
    product_id integer DEFAULT nextval('public.products_product_id_seq'::regclass) NOT NULL,
    product_name text,
    price integer,
    category text,
    image text,
    description text,
    quantity integer
);


ALTER TABLE public.products OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    user_id bigint NOT NULL,
    username text,
    password text,
    email text,
    is_admin boolean,
    credit_limit integer
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_user_id_seq OWNER TO postgres;

--
-- Name: users_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_user_id_seq OWNED BY public.users.user_id;


--
-- Name: orders order_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders ALTER COLUMN order_id SET DEFAULT nextval('public.orders_order_id_seq'::regclass);


--
-- Name: users user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN user_id SET DEFAULT nextval('public.users_user_id_seq'::regclass);


--
-- Data for Name: order_products; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.order_products (product_id, order_id, quanatity, price) FROM stdin;
98	11	1	8000
100	11	1	9000
105	11	1	19000
105	15	1	19000
\.


--
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orders (order_id, date, amount, user_id) FROM stdin;
9	2020-04-12	100	57
11	\N	\N	57
15	\N	\N	67
\.


--
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.products (product_id, product_name, price, category, image, description, quantity) FROM stdin;
99	  Lenovo V130	9000	  laptops	Images/item_L_102052136_6724a4895395d.jpg	  Operating System: windowsHard Disk Capacity: 1 tbProcessor Family: intel core i3Screen Size: 15 - 15.9 inchMemory Size: 4 gb	33
105	HP 9EV92EA ABV Pavilion 15	19000	laptops	Images/item_L_110270193_ba7990649cd9e.jpg	Operating System: windowsHard Disk Capacity: 1.256 tbProcessor Family: intel 9th generation core i7Screen Size: 15 - 15.9 inchMemory Size: 16 gb	8
102	Lenovo V 131	5000	laptops	Images/item_L_65844125_6710d01b1092a.jpg	Operating System: dosHard Disk Capacity: 1 tbProcessor Family: intel core i3Screen Size: 15 - 15.9 inchesMemory Size: 4 gb	5
101	Lenovo IdeaPad 330	4000	laptops	Images/item_L_65589696_c973919881ade.jpg	Operating System: dosHard Disk Capacity: 1 tbProcessor Family: amd a4 seriesScreen Size: 15 - 15.9 inchesMemory Size: 4 gb	5
104	HP PRO Book 450 G5	8700	laptops	Images/item_L_49167846_83ba8552543c9.jpg	Operating System: windowsHard Disk Capacity: 500 gbProcessor Family: intel 8th generation core i5Screen Size: 15 - 15.9 inchMemory Size: 4 gb	100
95	Huawei-y7-prime	2000	mobiles	Images/huawei-y7-prime-2019.jpg	Dimensions\t158.9 x 76.9 x 8.1 mm (6.26 x 3.03 x 0.32 in)Weight\t168 g (5.93 oz)Build\tGlass front, plastic back, plastic frameSIM\tHybrid Dual SIM (Nano-SIM, dual stand-by)	55
100	Lenovo 81TK009VED ideapad C340	9000	laptops	Images/item_L_117707594_e4e80a942bda3.jpg	Operating System: windowsHard Disk Capacity: 256 gbProcessor Family: intel 10th generation core i3Screen Size: 14 - 14.9 inchMemory Size: 4 gb	65
94	Huawei-nova-4	2200	mobiles	Images/huawei-nova-4-.jpg	Dimensions\t160.8 x 76.1 x 8.4 mm (6.33 x 3.00 x 0.33 in)\nWeight\t196 g (6.91 oz)\nBuild\tGlass front, glass back, aluminum frame\nSIM\tSingle SIM (Nano-SIM) or Hybrid Dual SIM (Nano-SIM, dual stand-by)\n \tIP53 dust and splash protection	8
90	Huawei-nova-5i	2000	mobiles	Images/huawei-nova-5i-pro.jpg	Dimensions\t156.1 x 73.9 x 8.3 mm (6.15 x 2.91 x 0.33 in)\nWeight\t178 g (6.28 oz)\nBuild\tGlass front, plastic back, plastic frame\nSIM\tHybrid Dual SIM (Nano-SIM, dual stand-by)	1
91	Huawei-mate30-pro 	3000	mobiles	Images/huawei-mate30-.jpg	Dimensions\t160.8 x 76.1 x 8.4 mm (6.33 x 3.00 x 0.33 in)\nWeight\t196 g (6.91 oz)\nBuild\tGlass front, glass back, aluminum frame\nSIM\tSingle SIM (Nano-SIM) or Hybrid Dual SIM (Nano-SIM, dual stand-by)\n \tIP53 dust and splash protection	10
92	Huawei-y9-prime	2500	mobiles	Images/huawei-y9-prime-2019-.jpg	Dimensions\t160.8 x 76.1 x 8.4 mm (6.33 x 3.00 x 0.33 in)\nWeight\t196 g (6.91 oz)\nBuild\tGlass front, glass back, aluminum frame\nSIM\tSingle SIM (Nano-SIM) or Hybrid Dual SIM (Nano-SIM, dual stand-by)\n \tIP53 dust and splash protection	10
93	Huawei-nova-5t	2500	mobiles	Images/huawei-nova-5t.jpg	Dimensions\t160.8 x 76.1 x 8.4 mm (6.33 x 3.00 x 0.33 in)\nWeight\t196 g (6.91 oz)\nBuild\tGlass front, glass back, aluminum frame\nSIM\tSingle SIM (Nano-SIM) or Hybrid Dual SIM (Nano-SIM, dual stand-by)\n \tIP53 dust and splash protection	10
96	Samsung-galaxy-note10-plus	10000	mobiles	Images/samsung-galaxy-note10-plus-.jpg	\tDimensions\t162.3 x 77.2 x 7.9 mm (6.39 x 3.04 x 0.31 in)\nWeight\t196 g (6.91 oz)\nBuild\tGlass front (Gorilla Glass 6), glass back (Gorilla Glass 6), aluminum frame\nSIM\tSingle SIM (Nano-SIM) or Hybrid Dual SIM (Nano-SIM, dual stand-by)	10
97	Samsung-galaxy-m11	9000	mobiles	Images/samsung-galaxy-m11-sm-m115.jpg	Dimensions\t161.4 x 76.3 x 9 mm (6.35 x 3.00 x 0.35 in)\nWeight\t197 g (6.95 oz)\nBuild\tGlass front, plastic back, plastic frame\nSIM\tDual SIM (Nano-SIM, dual stand-by)	10
98	Samsung-galaxy-s8	8000	mobiles	Images/samsung-galaxy-s8-.jpg	\tDimensions\t148.9 x 68.1 x 8 mm (5.86 x 2.68 x 0.31 in)\nWeight\t155 g (5.47 oz)\nBuild\tGlass front (Gorilla Glass 5), glass back (Gorilla Glass 5), aluminum frame\nSIM\tSingle SIM (Nano-SIM) or Hybrid Dual SIM (Nano-SIM, dual stand-by)	10
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (user_id, username, password, email, is_admin, credit_limit) FROM stdin;
1	admin	admin	\N	t	\N
57	ahmed	alsum	\N	\N	1000
67	bb	bb	bb@gmail.com	\N	50000
\.


--
-- Name: orders_order_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orders_order_id_seq', 15, true);


--
-- Name: products_product_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.products_product_id_seq', 130, true);


--
-- Name: users_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_user_id_seq', 67, true);


--
-- Name: order_products order_products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_products
    ADD CONSTRAINT order_products_pkey PRIMARY KEY (product_id, order_id);


--
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (order_id);


--
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (product_id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- Name: order_products order_products_order_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_products
    ADD CONSTRAINT order_products_order_id_fkey FOREIGN KEY (order_id) REFERENCES public.orders(order_id) ON DELETE CASCADE;


--
-- Name: order_products order_products_product_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_products
    ADD CONSTRAINT order_products_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.products(product_id);


--
-- Name: orders orders_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(user_id) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

