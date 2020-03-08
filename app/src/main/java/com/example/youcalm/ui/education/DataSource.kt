package com.example.youcalm.ui.education


class DataSource {

    companion object {

        fun createDataSet(): ArrayList<Article> {
            val list = ArrayList<Article>()
            list.add(
                Article(
                    "Soothe your mind",
                    "https://www.webmd.com/balance/stress-management/stress-relief-breathing-techniques#1",
                    "https://www.1stclassmed.com/hs-fs/hubfs/breathing%20exercise.jpg?width=2500&name=breathing%20exercise.jpg",
                    "Breathing excersises"
                )
            )
            list.add(
                Article(
                    "Time to Build a Kotlin App!",
                    "The REST API course is complete. You can find the videos here: https://codingwithmitch.com/courses/build-a-rest-api/.",
                    "https://www.verywellmind.com/thmb/KNXOk1WBunBmktSAd23bjpe8930=/700x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/top-symptoms-of-panic-attacks-2584270_FINAL-5bcdfd4d46e0fb0051228ee5.png",
                    "mitch"
                )
            )

            list.add(
                Article(
                    "Interviewing a Web Developer and YouTuber",
                    "Justin has been producing online courses for YouTube, Udemy, and his website CodingForEntrepreneurs.com for over 5 years.",
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/coding_for_entrepreneurs.png",
                    "John"
                )
            )
            list.add(
                Article(
                    "Freelance Android Developer (Vasiliy Zukanov)",
                    "Vasiliy has been a freelance android developer for several years. He also has some of the best android development courses I've had the pleasure of taking on Udemy.com.",
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/freelance_android_dev_vasiliy_zukanov.png",
                    "Steven"
                )
            )
            list.add(
                Article(
                    "Freelance Android Developer, Donn Felker",
                    "Freelancing as an Android developer with Donn Felker.\\r\\n\\r\\nDonn is also:\\r\\n\\r\\n1) Founder of caster.io\\r\\n\\r\\n2) Co-host of the fragmented podcast (fragmentedpodcast.com).",
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/freelance_android_dev_donn_felker.png",
                    "Richelle"
                )
            )
            list.add(
                Article(
                    "Work Life Balance for Software Developers",
                    "What kind of hobbies do software developers have? It sounds like many software developers don't have a lot of hobbies and choose to focus on work. Is that a good idea?",
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/work_life_balance.png",
                    "Jessica"
                )
            )
            list.add(
                Article(
                    "Full Stack Web Developer - Nicholas Olsen",
                    "In this podcast I interviewed the Fullsnack Developer (AKA Nicholas Olsen).\\r\\n\\r\\nNicholas is many things. What I mean by that is, he's good at many things.\\r\\n\\r\\n1. He’s an entrepreneur\\r\\n\\r\\n2. Web developer\\r\\n\\r\\n3. Artist\\r\\n\\r\\n4. Graphic designer\\r\\n\\r\\n5. Musician (drums)\\r\\n\\r\\n6. Professional BodyBuilder.",
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/fullsnack_developer.png",
                    "Guy"
                )
            )
            list.add(
                Article(
                    "Javascript Expert - Wes Bos",
                    "Interviewing a web developer, javascript expert, entrepreneur, freelancer, podcaster, and much more.",
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/javascript_expert_wes_bos.png",
                    "Ruby"
                )
            )
            list.add(
                Article(
                    "Senior Android Engineer - Kaushik Gopal",
                    "Kaushik Gopal is a Senior Android Engineer working in Silicon Valley.\r\n\r\nHe works as a Senior Staff engineer at Instacart.\r\n\r\nInstacart: https://www.instacart.com/",
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/senior_android_engineer_kaushik_gopal.png",
                    "mitch"
                )
            )
            return list
        }
    }
}
